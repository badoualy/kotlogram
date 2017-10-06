package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.log.Logger
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.model.MTSession
import com.github.badoualy.telegram.mtproto.net.MTProtoConnection
import com.github.badoualy.telegram.mtproto.net.MTProtoTcpConnection
import com.github.badoualy.telegram.mtproto.secure.MTProtoMessageEncryption
import com.github.badoualy.telegram.mtproto.time.MTProtoTimer
import com.github.badoualy.telegram.mtproto.time.TimeOverlord
import com.github.badoualy.telegram.mtproto.tl.*
import com.github.badoualy.telegram.mtproto.util.NamedThreadFactory
import com.github.badoualy.telegram.tl.StreamUtils
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLApiContext
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.DeserializationException
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import com.github.badoualy.telegram.tl.serialization.TLStreamDeserializer
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.io.ByteArrayInputStream
import java.io.IOException
import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class MTProtoHandler {

    private val ACK_BUFFER_SIZE = 15
    private val ACK_BUFFER_TIMEOUT: Long = TimeUnit.SECONDS.toMillis(150)

    private var connection: MTProtoConnection? = null
    var authKey: AuthKey? = null
        private set
    var session: MTSession
        private set

    private var messageSubscription: Disposable? = null
    private val subscriberMap = Hashtable<Long, ObservableEmitter<TLMethod<*>>>(10)
    private val requestMap = Hashtable<Long, TLMethod<*>>(10)
    private val sentMessageList = ArrayList<MTProtoMessage>(10)
    private var messageToAckList = ArrayList<Long>(ACK_BUFFER_SIZE)
    private var requestQueue = LinkedList<QueuedMethod<*>>()

    private var bufferTimeoutTask: TimerTask? = null
    private var bufferId = 0

    private val apiCallback: MTProtoUpdateCallback?

    constructor(authResult: AuthResult, apiCallback: MTProtoUpdateCallback?) {
        this.apiCallback = apiCallback

        connection = authResult.connection
        session = MTSession(connection!!.dataCenter)
        session.salt = authResult.serverSalt
        connection!!.tag = session.tag
        authKey = authResult.authKey
        logger.debug(session.tag, "New handler from authResult")
    }

    @Throws(IOException::class)
    constructor(dataCenter: DataCenter, authKey: AuthKey, session: MTSession?, apiCallback: MTProtoUpdateCallback?) {
        this.apiCallback = apiCallback

        this.session = session ?: MTSession(dataCenter)
        connection = MTProtoTcpConnection(dataCenter.ip, dataCenter.port, this.session.tag)
        this.authKey = authKey
        logger.debug(this.session.tag, "New handler from existing key")
    }

    private fun newSession(dataCenter: DataCenter): MTSession {
        val session = MTSession(dataCenter)
        logger.warn(session.tag, "New session created")
        return session
    }

    fun startWatchdog() {
        logger.info(session.tag, "startWatchdog()")
        messageSubscription = connection!!.getMessageObservable()
                .observeOn(Schedulers.computation())
                .subscribeBy(onNext = { onMessageReceived(it) },
                             onError = { onErrorReceived(it) },
                             onComplete = { messageSubscription = null })
    }

    private fun stopWatchdog() {
        messageSubscription?.dispose()
        messageSubscription = null
    }

    /** Close the connection and re-open another one */
    @Throws(IOException::class)
    fun resetConnection() {
        logger.error(session.tag, "resetConnection()")
        bufferTimeoutTask?.cancel()
        onBufferTimeout(bufferId, false)
        close()

        session = newSession(connection!!.dataCenter)
        connection = MTProtoTcpConnection(connection!!.ip, connection!!.port, session.tag)
        startWatchdog()
        executeMethod(TLRequestHelpGetNearestDc(), 5L)
    }

    /** Properly close the connection to Telegram's server after sending ACK for messages if any to send */
    fun close() {
        logger.info(session.tag, "close()")
        bufferTimeoutTask?.cancel()
        onBufferTimeout(bufferId)
        try {
            stopWatchdog()
            connection!!.close()
        } catch (e: IOException) {
        }

        subscriberMap.clear()
        requestMap.clear()
        sentMessageList.clear()
        messageToAckList.clear()
        requestQueue.clear()
    }

    @Throws(IOException::class)
    fun <T : TLObject> executeMethodSync(method: TLMethod<T>, timeout: Long): T =
            executeMethod(method, timeout).blockingFirst()

    /**
     * Execute the given methods synchronously and return the list of results (guaranties the order is conserved)
     * @param methods methods to execute
     * @param timeout timeout before returning an error
     */
    @Throws(IOException::class)
    fun <T : TLObject> executeMethodsSync(methods: List<TLMethod<out T>>, timeout: Long): List<T> =
            executeMethods(methods, timeout).blockingIterable()
                    .sortedBy { methods.indexOf(it) }.map { it.response!! }.toList()

    /**
     * Queue a method to be executed with the next message.
     * @param method method to execute
     * @param type of queue
     * @param validityTimeout validity duration in ms, if nothing is sent during this period, this method will be discarded/send depending on type
     * @param timeout request timeout (applied on the observable)
     * @return an observable that will receive one unique item being the response
     */
    fun <T : TLObject> queueMethod(method: TLMethod<T>, type: Int = QUEUE_TYPE_DISCARD, validityTimeout: Long, timeout: Long): Observable<T> = Observable.create<TLMethod<T>> { subscriber ->
        synchronized(requestQueue) {
            logger.debug(session.tag, "Queued $method with validityTimeout of $validityTimeout")
            requestQueue.add(QueuedMethod(method,
                                          System.currentTimeMillis() + validityTimeout,
                                          subscriber))
        }
    }.map { it.response!! }.timeout(timeout, TimeUnit.MILLISECONDS)

    /**
     * Execute the given method
     * @param method methods to execute
     * @param timeout timeout before returning an error
     * @param T response type
     * @return an observable that will receive one unique item being the response
     * @throws IOException
     */
    @Throws(IOException::class)
    fun <T : TLObject> executeMethod(method: TLMethod<T>, timeout: Long): Observable<T> =
            executeMethods(listOf(method), timeout).map { it.response }

    /**
     * Execute the given methods, generates a message id, serialize the methods, encrypt and send
     * @param methods methods to execute
     * @param timeout timeout before returning an error
     * @param T response type
     * @return an observable that will receive one unique item being the response
     * @throws IOException
     */
    @Throws(IOException::class)
    fun <T : TLObject> executeMethods(methods: List<TLMethod<out T>>, timeout: Long): Observable<TLMethod<T>> {
        if (methods.isEmpty())
            throw IllegalArgumentException("No methods to execute")

        logger.debug(session.tag, "executeMethodSync ${methods.joinToString(", ")}")
        val observable = Observable.create<TLMethod<T>> { emitter ->
            try {
                @Suppress("UNCHECKED_CAST")
                emitter as ObservableEmitter<TLMethod<*>>

                val mtMessages = ArrayList<MTProtoMessage>(2)

                // ACK
                val extraAck = getAckToSend()
                if (extraAck != null)
                    mtMessages.add(extraAck)

                // Queued method
                val extraMethod = getQueuedRequestToSend()
                if (extraMethod.isNotEmpty()) {
                    logger.trace(session.tag, "Queued ${extraMethod.size} methods")
                    mtMessages.addAll(extraMethod)
                }

                // Methods
                methods.forEach { method ->
                    val mtMessage = MTProtoMessage(session.generateMessageId(),
                                                   session.generateSeqNo(method),
                                                   method.serialize())
                    mtMessages.add(mtMessage)
                    logger.info(session.tag,
                                "Sending method $method with msgId ${mtMessage.messageId} and seqNo ${mtMessage.seqNo}")

                    subscriberMap.put(mtMessage.messageId, emitter)
                    requestMap.put(mtMessage.messageId, method)
                }

                // Wrap in container if needed, or send as is
                if (mtMessages.size > 1) {
                    logger.debug(session.tag, "Sending methods in container")
                    val container = MTMessagesContainer()
                    container.messages.addAll(mtMessages)
                    sendMessage(MTProtoMessage(session.generateMessageId(),
                                               session.generateSeqNo(container),
                                               container.serialize()))
                } else {
                    logger.debug(session.tag, "Sending single method")
                    sendMessage(mtMessages.first())
                }
            } catch (e: IOException) {
                emitter.onError(e)
            }
        }
        return observable.timeout(timeout, TimeUnit.MILLISECONDS)
    }

    /**
     * Acknowledge the given message id to the server. The request may be sent later, it is added to a queue, the queue of messages
     * will be sent when a method is executed, or when a timeout value has passed since the first element of the queue was added,
     * or if the queue is full
     *
     * @param messageId message id to acknowledge
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun sendMessageAck(messageId: Long) {
        var flush = false
        var startTimer = false
        var list: ArrayList<Long>? = null
        var id: Int = -1

        synchronized(messageToAckList) {
            list = messageToAckList
            list!!.add(messageId)
            logger.trace(session.tag, "Adding msgId $messageId to bufferId $bufferId")
            id = bufferId

            if (list!!.size == 1)
                startTimer = true
            else if (list!!.size < ACK_BUFFER_SIZE)
                return
            else {
                messageToAckList = ArrayList<Long>(ACK_BUFFER_SIZE)
                bufferId++
                flush = true
            }
        }

        if (startTimer) {
            try {
                bufferTimeoutTask = MTProtoTimer.schedule(ACK_BUFFER_TIMEOUT,
                                                          { onBufferTimeout(id) })
            } catch (e: IllegalStateException) {
                // TODO: remove Timer use
                // Timer already cancelled.
            }
        }
        if (flush) {
            logger.info(session.tag, "Flushing ack buffer")
            bufferTimeoutTask?.cancel()
            bufferTimeoutTask = null
            sendMessagesAck(list!!.toLongArray())
        }
    }

    /** If buffer timed out, check that the relevant buffer wasn't already flushed, and if not, flush it */
    private fun onBufferTimeout(id: Int, flush: Boolean = true) {
        if (!(connection?.isAlive() ?: false))
            return

        var list: ArrayList<Long>? = null

        synchronized(messageToAckList) {
            if (id != bufferId) {
                // Already flushed
                return
            }

            list = messageToAckList
            messageToAckList = ArrayList<Long>(ACK_BUFFER_SIZE)
            bufferId++
        }

        if (flush)
            sendMessagesAck(list!!.toLongArray())
    }

    /**
     * Send acknowledgment request to server for the given messages
     *
     * @param messagesId message id to acknowledge
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun sendMessagesAck(messagesId: LongArray) {
        if (messagesId.isEmpty())
            return

        val ackMessage = MTMsgsAck(messagesId)
        val ackMessageId = session.generateMessageId()
        logger.debug(session.tag,
                     "Sending ack for messages ${messagesId.joinToString(
                             ", ")} with ackMsgId $ackMessageId")
        // TODO: get message queue
        sendMessage(MTProtoMessage(ackMessageId,
                                   session.generateSeqNo(ackMessage),
                                   ackMessage.serialize()))
    }

    /**
     * Send a message after encrypting it
     * @param message message to encrypt then send
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun sendMessage(message: MTProtoMessage) {
        logger.debug(session.tag,
                     "Sending message with msgId ${message.messageId} and seqNo ${message.seqNo}")
        val encryptedMessage = MTProtoMessageEncryption.generateEncryptedMessage(authKey!!,
                                                                                 session.id,
                                                                                 session.salt,
                                                                                 message)
        sendData(encryptedMessage.data)
        sentMessageList.add(message)
    }

    /**
     * Send data using the connection
     * @param data data to send
     * @throws IOException
     */
    private fun sendData(data: ByteArray) = connection!!.sendMessage(data)

    /** Build a container with all the extras to send with a method invocation called */
    private fun getAckToSend(): MTProtoMessage? {
        // Collect messages to ack
        var toAckList: ArrayList<Long>? = null
        synchronized(messageToAckList) {
            toAckList = messageToAckList
            if (messageToAckList.isNotEmpty()) {
                messageToAckList = ArrayList<Long>(ACK_BUFFER_SIZE)
                bufferId++
                bufferTimeoutTask?.cancel()
                bufferTimeoutTask = null
            }
        }

        if (toAckList?.size ?: 0 > 0) {
            val ack = MTMsgsAck(toAckList!!.toLongArray())
            val ackMessage = MTProtoMessage(session.generateMessageId(),
                                            session.generateSeqNo(ack),
                                            ack.serialize())
            logger.debug(session.tag,
                         "Building ack for messages ${toAckList!!.joinToString(
                                 ", ")} with msgId ${ackMessage.messageId} and seqNo ${ackMessage.seqNo}")
            return ackMessage
        }

        logger.debug(session.tag, "No extra ack to send")
        return null
    }

    /** Build a list of messages to send with the next request from the queued requests */
    private fun getQueuedRequestToSend(): List<MTProtoMessage> {
        var toSend: MutableList<QueuedMethod<*>>? = null
        synchronized(requestQueue) {
            if (requestQueue.isNotEmpty()) {
                toSend = ArrayList<QueuedMethod<*>>(5)
                var request: QueuedMethod<*>?
                val time = System.currentTimeMillis()
                while (requestQueue.isNotEmpty()) {
                    request = requestQueue.remove()
                    if (request.validityTimeout < time) {
                        logger.debug(session.tag,
                                     "Queued method ${request.method} timed out, dropping")
                        request.subscriber.onComplete()
                    } else {
                        toSend!!.add(request)
                    }
                }
            }
        }

        if (toSend == null || toSend!!.isEmpty())
            return emptyList()

        return toSend!!.map {
            val msgId = session.generateMessageId()
            @Suppress("UNCHECKED_CAST")
            val s = it.subscriber as ObservableEmitter<TLMethod<*>>
            subscriberMap.put(msgId, s)
            requestMap.put(msgId, it.method)
            MTProtoMessage(msgId, session.generateSeqNo(it.method), it.method.serialize())
        }.toList()
    }

    private fun onErrorReceived(it: Throwable) {
        logger.error(session.tag, "onErrorReceived()", it)
        val singleSubscriber = subscriberMap.maxBy { it.key }?.value
        if (singleSubscriber != null) {
            logger.debug(session.tag, "Found a single subscriber, sending timeout")
            singleSubscriber.onError(TimeoutException())
        } else {
            resetConnection()
        }
    }

    private fun onMessageReceived(bytes: ByteArray) {
        var message: MTProtoMessage = MTProtoMessage()
        try {
            if (bytes.size == 4) {
                onErrorReceived(RpcErrorException(StreamUtils.readInt(bytes), "INVALID_AUTH_KEY"))
                return
            }

            message = MTProtoMessageEncryption.extractMessage(authKey!!, session.id, bytes)
            logger.debug(session.tag,
                         "Received msg ${message.messageId} with seqNo ${message.seqNo}")

            // Check if is a container
            when (StreamUtils.readInt(message.payload)) {
                MTMessagesContainer.CONSTRUCTOR_ID -> {
                    logger.trace(session.tag, "Message is a container")
                    val tlDeserializer = TLStreamDeserializer(ByteArrayInputStream(message.payload),
                                                              mtProtoContext)
                    val container = tlDeserializer.readTLObject(MTMessagesContainer::class,
                                                                MTMessagesContainer.CONSTRUCTOR_ID)
                    logger.trace(session.tag, "Container has ${container.messages.size} items")
                    if (container.messages.firstOrNull() { m -> m.messageId >= message.messageId } != null) {
                        logger.warn(session.tag,
                                    "Message contained in container has a same or greater msgId than container, ignoring whole container")
                        throw SecurityException(
                                "Message contained in container has a same or greater msgId than container, ignoring whole container")
                    }

                    for (msg in container.messages)
                        handleMessage(msg)
                }
                else -> handleMessage(message)
            }
        } catch (e: IOException) {
            logger.error(session.tag, "Unknown error", e) // Can't do anything better
            logger.error(session.tag, "Hex dump ${StreamUtils.toHexString(message.payload)}")
        }
    }

    @Throws(DeserializationException::class, IOException::class)
    private fun deserializeMessageContent(message: MTProtoMessage): TLObject {
        // Default container, handle content
        val classId = StreamUtils.readInt(message.payload)
        logger.trace(session.tag, "Reading constructor $classId")

        val context =
                if (mtProtoContext.contains(classId)) {
                    logger.trace(session.tag, "$classId is supported by MTProtoContext")
                    mtProtoContext
                } else {
                    logger.trace(session.tag, "$classId is not supported by MTProtoContext")
                    apiContext
                }

        return TLStreamDeserializer(ByteArrayInputStream(message.payload), context).readTLObject()
    }

    @Throws(IOException::class)
    private fun handleMessage(message: MTProtoMessage) {
        val messageContent = deserializeMessageContent(message)
        logger.debug(session.tag, "handle $messageContent")

        when (messageContent) {
            is MTMsgsAck -> {
                logger.debug(session.tag,
                             "Received ack for ${messageContent.messages.joinToString(", ")}")
                // TODO check missing ack ?
            }
            is MTRpcResult -> {
                handleResult(messageContent)
                sendMessageAck(message.messageId)
            }
            is TLAbsUpdates -> {
                updatePool.execute { apiCallback?.onUpdates(messageContent) }
                sendMessageAck(message.messageId)
            }
            is MTNewSessionCreated -> {
                //salt = message.serverSalt
                sendMessageAck(message.messageId)
            }
            is MTBadMessageNotification -> handleBadMessage(messageContent, message)
            is MTBadServerSalt -> {
                logger.error(session.tag, messageContent.toPrettyString())

                // Message contains a good salt to use
                session.salt = messageContent.newSalt

                // Resend message with good salt
                val sentMessage = sentMessageList.filter { it.messageId == messageContent.badMsgId }.firstOrNull()
                if (sentMessage != null) {
                    logger.warn(session.tag,
                                "Re-sending message ${messageContent.badMsgId} with new salt")
                    sendMessage(sentMessage)
                } else {
                    logger.error(session.tag,
                                 "Couldn't find sentMessage in history with msgId ${messageContent.badMsgId}, can't re-send with good salt")
                }
            }
            is MTNeedResendMessage -> {
                logger.warn(session.tag, "TODO MTNeedResendMessage")
                // TODO
            }
            is MTNewMessageDetailedInfo -> {
                logger.warn(session.tag, "TODO MTNewMessageDetailedInfo")
                // TODO
            }
            is MTMessageDetailedInfo -> {
                logger.warn(session.tag, "TODO MTMessageDetailedInfo")
                // TODO
            }
            is MTFutureSalts -> {
                logger.warn(session.tag, "TODO MTFutureSalts")
                // TODO
            }
            else -> {
                logger.error(session.tag,
                             "Unsupported constructor in handleMessage() $messageContent: ${messageContent.javaClass.simpleName}")
                throw IllegalStateException(
                        "Unsupported constructor in handleMessage() $messageContent: ${messageContent.javaClass.simpleName}")
            }
        }
    }

    @Throws(IOException::class)
    private fun handleBadMessage(badMessage: MTBadMessageNotification, container: MTProtoMessage) {
        logger.error(session.tag, badMessage.toPrettyString())

        when (badMessage.errorCode) {
            MTBadMessage.ERROR_MSG_ID_TOO_LOW, MTBadMessage.ERROR_MSG_ID_TOO_HIGH -> {
                session.lastMessageId = 0
                TimeOverlord.synchronizeTime(connection!!.dataCenter, container.messageId)

                // Resend message with good salt
                val sentMessage = sentMessageList.filter { it.messageId == badMessage.badMsgId }.firstOrNull()
                if (sentMessage != null) {
                    // Update map and generate new msgId
                    val subscriber = subscriberMap.remove(sentMessage.messageId)
                    val request = requestMap.remove(sentMessage.messageId)
                    sentMessage.messageId = session.generateMessageId()
                    subscriberMap.put(sentMessage.messageId, subscriber)
                    requestMap.put(sentMessage.messageId, request)

                    logger.debug(session.tag,
                                 "Re-sending message ${badMessage.badMsgId} with new msgId ${sentMessage.messageId}")
                    sendMessage(sentMessage)
                } else {
                    logger.error(session.tag,
                                 "Couldn't find sentMessage in history with msgId ${badMessage.badMsgId}, can't re-send with good msgId")
                }
            }
            MTBadMessage.ERROR_SEQNO_TOO_LOW, MTBadMessage.ERROR_SEQNO_TOO_HIGH -> {
                if (badMessage.errorCode == MTBadMessage.ERROR_MSG_ID_TOO_LOW)
                    session.contentRelatedCount++
                else
                    session.contentRelatedCount--

                // Resend message with good seqno
                val sentMessage = sentMessageList.filter { it.messageId == badMessage.badMsgId }.firstOrNull()
                if (sentMessage != null) {
                    logger.warn(session.tag,
                                "Re-sending message ${badMessage.badMsgId} with new seqno")
                    sendMessage(sentMessage)
                } else {
                    logger.error(session.tag,
                                 "Couldn't find sentMessage in history with msgId ${badMessage.badMsgId}, can't re-send with good seqno")
                }
            }
            MTBadMessage.ERROR_SEQNO_EXPECTED_EVEN -> {
                // Should never happen
                logger.error(session.tag, "ERROR_SEQNO_EXPECTED_EVEN for ${badMessage.badMsgId}")
            }
            MTBadMessage.ERROR_SEQNO_EXPECTED_ODD -> {
                // Should never happen
                logger.error(session.tag, "ERROR_SEQNO_EXPECTED_ODD for ${badMessage.badMsgId}")
            }
            MTBadMessage.ERROR_MSG_ID_MODULO -> {
                // Should never happen
                logger.error(session.tag, "ERROR_MSG_ID_MODULO for ${badMessage.badMsgId}")
            }
            else -> logger.error(session.tag, "Unknown error ${badMessage.toPrettyString()}")
        }
    }

    @Throws(IOException::class)
    private fun handleResult(result: MTRpcResult) {
        logger.debug(session.tag, "Got result for msgId ${result.messageId}")

        val subscriber =
                if (subscriberMap.containsKey(result.messageId)) {
                    subscriberMap.remove(result.messageId)!!
                } else {
                    logger.warn(session.tag, "No subscriber found for msgId ${result.messageId}")
                    null
                }

        val request =
                if (requestMap.containsKey(result.messageId)) {
                    requestMap.remove(result.messageId)!!
                } else {
                    logger.warn(session.tag,
                                "No request object found for msgId ${result.messageId}")
                    null
                }

        val classId = StreamUtils.readInt(result.content)
        logger.debug(session.tag, "Response is a $classId")
        if (mtProtoContext.contains(classId)) {
            val resultContent = TLStreamDeserializer(ByteArrayInputStream(result.content),
                                                     mtProtoContext).readTLObject<TLObject>()
            if (resultContent is MTRpcError) {
                logger.error(session.tag,
                             "rpcError ${resultContent.errorCode}: ${resultContent.message}")
                subscriber?.onError(RpcErrorException(resultContent.errorCode,
                                                      resultContent.errorTag))
            } else
                logger.error(session.tag, "Unsupported content $result")
        } else if (request != null) {
            request.deserializeResponse(result.content, apiContext)
            subscriber?.onNext(request)
        }

        if (subscriber != null && !subscriberMap.containsValue(subscriber))
            subscriber.onComplete()
    }

    companion object {

        private val logger = Logger(MTProtoHandler::class)

        private val mtProtoContext = MTProtoContext
        private val apiContext = TLApiContext

        /** Thread pool to forward update callback */
        private val updatePool = ThreadPoolExecutor(4, 8,
                                                    0L, TimeUnit.MILLISECONDS,
                                                    LinkedBlockingQueue<Runnable>(),
                                                    NamedThreadFactory("UpdatePool"))

        @JvmStatic
        val QUEUE_TYPE_DISCARD = 0
        //@JvmStatic val QUEUE_TYPE_FLUSH = 1

        /** Shutdown all the threads and common resources associated to this instance */
        @JvmStatic
        fun shutdown() {
            logger.warn("shutdown()")
            MTProtoWatchdog.shutdown()
            MTProtoTimer.shutdown()
        }
    }

    private data class QueuedMethod<T : TLObject>(val method: TLMethod<T>, val validityTimeout: Long, val subscriber: ObservableEmitter<in TLMethod<T>>)
}
