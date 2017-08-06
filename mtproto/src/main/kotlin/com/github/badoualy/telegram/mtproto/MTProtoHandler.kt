package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.model.MTSession
import com.github.badoualy.telegram.mtproto.secure.MTProtoMessageEncryption
import com.github.badoualy.telegram.mtproto.time.MTProtoTimer
import com.github.badoualy.telegram.mtproto.time.TimeOverlord
import com.github.badoualy.telegram.mtproto.tl.*
import com.github.badoualy.telegram.mtproto.transport.MTProtoConnection
import com.github.badoualy.telegram.mtproto.transport.MTProtoTcpConnection
import com.github.badoualy.telegram.mtproto.util.NamedThreadFactory
import com.github.badoualy.telegram.tl.StreamUtils
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLApiContext
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.DeserializationException
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import org.slf4j.LoggerFactory
import rx.Observable
import rx.Subscriber
import rx.schedulers.Schedulers
import java.io.IOException
import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

class MTProtoHandler {

    private val ACK_BUFFER_SIZE = 15
    private val ACK_BUFFER_TIMEOUT: Long = 150 * 1000

    private var connection: MTProtoConnection? = null
    var authKey: AuthKey? = null
        private set
    var session: MTSession
        private set

    private val subscriberMap = Hashtable<Long, Subscriber<TLMethod<*>>>(10)
    private val requestMap = Hashtable<Long, TLMethod<*>>(10)
    private val sentMessageList = ArrayList<MTMessage>(10)
    private var messageToAckList = ArrayList<Long>(ACK_BUFFER_SIZE)
    private var requestQueue = LinkedList<QueuedMethod<*>>()

    private var bufferTimeoutTask: TimerTask? = null
    private var bufferId = 0

    private val apiCallback: ApiCallback?
    private val tag: String

    constructor(authResult: AuthResult, apiCallback: ApiCallback?, tag: String) {
        this.tag = tag
        this.apiCallback = apiCallback

        connection = authResult.connection
        session = MTSession(connection!!.dataCenter, tag = tag)
        session.salt = authResult.serverSalt
        connection!!.tag = session.tag
        authKey = authResult.authKey
        logger.debug(session.marker, "New handler from authResult")
    }

    @Throws(IOException::class)
    constructor(dataCenter: DataCenter, authKey: AuthKey, session: MTSession?, apiCallback: ApiCallback?, tag: String) {
        this.apiCallback = apiCallback
        this.tag = tag

        this.session = session ?: MTSession(dataCenter, tag = tag)
        connection = MTProtoTcpConnection(dataCenter.ip, dataCenter.port, this.session.tag)
        this.authKey = authKey
        logger.debug(this.session.marker, "New handler from existing key")
    }

    private fun newSession(dataCenter: DataCenter): MTSession {
        val session = MTSession(dataCenter, tag = tag)
        logger.warn(session.marker, "New session created")
        return session
    }

    fun startWatchdog() {
        logger.info(session.marker, "startWatchdog()")
        MTProtoWatchdog.start(connection!!)
                .observeOn(Schedulers.computation())
                .subscribe({ onMessageReceived(it) },
                           { onErrorReceived(it) })
    }

    private fun stopWatchdog() = MTProtoWatchdog.stop(connection!!)

    /** Close the connection and re-open another one */
    @Throws(IOException::class)
    fun resetConnection() {
        logger.error(session.marker, "resetConnection()")
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
        logger.info(session.marker, "close()")
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
            executeMethod(method, timeout).toBlocking().first()

    /**
     * Execute the given methods synchronously and return the list of results (guaranties the order is conserved)
     * @param methods methods to execute
     * @param timeout timeout before returning an error
     */
    @Throws(IOException::class)
    fun <T : TLObject> executeMethodsSync(methods: List<TLMethod<out T>>, timeout: Long): List<T> =
            executeMethods(methods, timeout).toBlocking().toIterable()
                    .sortedBy { methods.indexOf(it) }.map { it.response }.toList()

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
            logger.debug(session.marker, "Queued $method with validityTimeout of $validityTimeout")
            requestQueue.add(QueuedMethod(method,
                                          System.currentTimeMillis() + validityTimeout,
                                          subscriber))
        }
    }.map { it.response }.timeout(timeout, TimeUnit.MILLISECONDS)

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

        logger.debug(session.marker, "executeMethod ${methods.joinToString(", ")}")
        val observable = Observable.create<TLMethod<T>> { subscriber ->
            try {
                val mtMessages = ArrayList<MTMessage>(2)

                // ACK
                val extraAck = getAckToSend()
                if (extraAck != null)
                    mtMessages.add(extraAck)

                // Queued method
                val extraMethod = getQueuedRequestToSend()
                if (extraMethod.isNotEmpty()) {
                    logger.trace(session.marker, "Queued ${extraMethod.size} methods")
                    mtMessages.addAll(extraMethod)
                }

                // Methods
                @Suppress("UNCHECKED_CAST")
                val s = subscriber as Subscriber<TLMethod<*>>
                methods.forEach { method ->
                    val mtMessage = MTMessage(session.generateMessageId(),
                                              session.generateSeqNo(method),
                                              method.serialize())
                    mtMessages.add(mtMessage)
                    logger.info(session.marker,
                                "Sending method $method with msgId ${mtMessage.messageId} and seqNo ${mtMessage.seqNo}")

                    subscriberMap.put(mtMessage.messageId, s)
                    requestMap.put(mtMessage.messageId, method)
                }

                // Wrap in container if needed, or send as is
                if (mtMessages.size > 1) {
                    logger.debug(session.marker, "Sending methods in container")
                    val container = MTMessagesContainer()
                    container.messages.addAll(mtMessages)
                    sendMessage(MTMessage(session.generateMessageId(),
                                          session.generateSeqNo(container),
                                          container.serialize()))
                } else {
                    logger.debug(session.marker, "Sending single method")
                    sendMessage(mtMessages.first())
                }
            } catch (e: IOException) {
                subscriber.onError(e)
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
            logger.trace(session.marker, "Adding msgId $messageId to bufferId $bufferId")
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
            } catch(e: IllegalStateException) {
                // TODO: remove Timer use
                // Timer already cancelled.
            }
        }
        if (flush) {
            logger.info(session.marker, "Flushing ack buffer")
            bufferTimeoutTask?.cancel()
            bufferTimeoutTask = null
            sendMessagesAck(list!!.toLongArray())
        }
    }

    /** If buffer timed out, check that the relevant buffer wasn't already flushed, and if not, flush it */
    private fun onBufferTimeout(id: Int, flush: Boolean = true) {
        if (!(connection?.isOpen() ?: false))
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
        logger.debug(session.marker,
                     "Sending ack for messages ${messagesId.joinToString(", ")} with ackMsgId $ackMessageId")
        // TODO: get message queue
        sendMessage(MTMessage(ackMessageId,
                              session.generateSeqNo(ackMessage),
                              ackMessage.serialize()))
    }

    /**
     * Send a message after encrypting it
     * @param message message to encrypt then send
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun sendMessage(message: MTMessage) {
        logger.debug(session.marker,
                     "Sending message with msgId ${message.messageId} and seqNo ${message.seqNo}")
        val encryptedMessage = MTProtoMessageEncryption.encrypt(authKey!!,
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
    private fun sendData(data: ByteArray) = connection!!.writeMessage(data)

    /** Build a container with all the extras to send with a method invocation called */
    private fun getAckToSend(): MTMessage? {
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
            val ackMessage = MTMessage(session.generateMessageId(),
                                       session.generateSeqNo(ack),
                                       ack.serialize())
            logger.debug(session.marker,
                         "Building ack for messages ${toAckList!!.joinToString(", ")} with msgId ${ackMessage.messageId} and seqNo ${ackMessage.seqNo}")
            return ackMessage
        }

        logger.debug(session.marker, "No extra ack to send")
        return null
    }

    /** Build a list of messages to send with the next request from the queued requests */
    private fun getQueuedRequestToSend(): List<MTMessage> {
        var toSend: MutableList<QueuedMethod<*>>? = null
        synchronized(requestQueue) {
            if (requestQueue.isNotEmpty()) {
                toSend = ArrayList<QueuedMethod<*>>(5)
                var request: QueuedMethod<*>?
                val time = System.currentTimeMillis()
                while (requestQueue.isNotEmpty()) {
                    request = requestQueue.remove()
                    if (request.validityTimeout < time) {
                        logger.debug(session.marker,
                                     "Queued method ${request.method} timed out, dropping")
                        request.subscriber.onCompleted()
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
            val s = it.subscriber as Subscriber<TLMethod<*>>
            subscriberMap.put(msgId, s)
            requestMap.put(msgId, it.method)
            MTMessage(msgId, session.generateSeqNo(it.method), it.method.serialize())
        }.toList()
    }

    private fun onErrorReceived(it: Throwable) {
        logger.error(session.marker, "onErrorReceived()", it)
        val singleSubscriber = subscriberMap.maxBy { it.key }?.value
        if (singleSubscriber != null) {
            logger.debug(session.marker, "Found a single subscriber, sending timeout")
            singleSubscriber.onError(TimeoutException())
        } else {
            resetConnection()
        }
    }

    private fun onMessageReceived(bytes: ByteArray) {
        var message: MTMessage = MTMessage()
        try {
            if (bytes.size == 4) {
                onErrorReceived(RpcErrorException(StreamUtils.readInt(bytes), "INVALID_AUTH_KEY"))
                return
            }

            message = MTProtoMessageEncryption.decrypt(authKey!!, session.id, bytes)
            logger.debug(session.marker,
                         "Received msg ${message.messageId} with seqNo ${message.seqNo}")

            // Check if is a container
            when (StreamUtils.readInt(message.payload)) {
                MTMessagesContainer.CONSTRUCTOR_ID -> {
                    logger.trace(session.marker, "Message is a container")
                    val container = mtProtoContext.deserializeMessage(message.payload,
                                                                      MTMessagesContainer::class.java,
                                                                      MTMessagesContainer.CONSTRUCTOR_ID)
                    logger.trace(session.marker, "Container has ${container.messages.size} items")
                    if (container.messages.firstOrNull() { m -> m.messageId >= message.messageId } != null) {
                        logger.warn(session.marker,
                                    "Message contained in container has a same or greater msgId than container, ignoring whole container")
                        throw SecurityException("Message contained in container has a same or greater msgId than container, ignoring whole container")
                    }

                    for (msg in container.messages)
                        handleMessage(msg)
                }
                else -> handleMessage(message)
            }
        } catch (e: IOException) {
            logger.error(session.marker, "Unknown error", e) // Can't do anything better
            logger.error(session.marker, "Hex dump ${StreamUtils.toHexString(message.payload)}")
        }
    }

    @Throws(DeserializationException::class, IOException::class)
    private fun deserializeMessageContent(message: MTMessage): TLObject {
        // Default container, handle content
        val classId = StreamUtils.readInt(message.payload)
        logger.trace(session.marker, "Reading constructor $classId")
        if (mtProtoContext.isSupportedObject(classId)) {
            logger.trace(session.marker, "$classId is supported by MTProtoContext")
            return mtProtoContext.deserializeMessage(message.payload)
        }

        logger.trace(session.marker, "$classId is not supported by MTProtoContext")
        return apiContext.deserializeMessage(message.payload)
    }

    @Throws(IOException::class)
    private fun handleMessage(message: MTMessage) {
        val messageContent = deserializeMessageContent(message)
        logger.debug(session.marker, "handle $messageContent")

        when (messageContent) {
            is MTMsgsAck -> {
                logger.debug(session.marker,
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
                logger.error(session.marker, messageContent.toPrettyString())

                // Message contains a good salt to use
                session.salt = messageContent.newSalt

                // Resend message with good salt
                val sentMessage = sentMessageList.filter { it.messageId == messageContent.badMsgId }.firstOrNull()
                if (sentMessage != null) {
                    logger.warn(session.marker,
                                "Re-sending message ${messageContent.badMsgId} with new salt")
                    sendMessage(sentMessage)
                } else {
                    logger.error(session.marker,
                                 "Couldn't find sentMessage in history with msgId ${messageContent.badMsgId}, can't re-send with good salt")
                }
            }
            is MTNeedResendMessage -> {
                logger.warn(session.marker, "TODO MTNeedResendMessage")
                // TODO
            }
            is MTNewMessageDetailedInfo -> {
                logger.warn(session.marker, "TODO MTNewMessageDetailedInfo")
                // TODO
            }
            is MTMessageDetailedInfo -> {
                logger.warn(session.marker, "TODO MTMessageDetailedInfo")
                // TODO
            }
            is MTFutureSalts -> {
                logger.warn(session.marker, "TODO MTFutureSalts")
                // TODO
            }
            else -> {
                logger.error(session.marker,
                             "Unsupported constructor in handleMessage() $messageContent: ${messageContent.javaClass.simpleName}")
                throw IllegalStateException("Unsupported constructor in handleMessage() $messageContent: ${messageContent.javaClass.simpleName}")
            }
        }
    }

    @Throws(IOException::class)
    private fun handleBadMessage(badMessage: MTBadMessageNotification, container: MTMessage) {
        logger.error(session.marker, badMessage.toPrettyString())

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

                    logger.debug(session.marker,
                                 "Re-sending message ${badMessage.badMsgId} with new msgId ${sentMessage.messageId}")
                    sendMessage(sentMessage)
                } else {
                    logger.error(session.marker,
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
                    logger.warn(session.marker,
                                "Re-sending message ${badMessage.badMsgId} with new seqno")
                    sendMessage(sentMessage)
                } else {
                    logger.error(session.marker,
                                 "Couldn't find sentMessage in history with msgId ${badMessage.badMsgId}, can't re-send with good seqno")
                }
            }
            MTBadMessage.ERROR_SEQNO_EXPECTED_EVEN -> {
                // Should never happen
                logger.error(session.marker, "ERROR_SEQNO_EXPECTED_EVEN for ${badMessage.badMsgId}")
            }
            MTBadMessage.ERROR_SEQNO_EXPECTED_ODD -> {
                // Should never happen
                logger.error(session.marker, "ERROR_SEQNO_EXPECTED_ODD for ${badMessage.badMsgId}")
            }
            MTBadMessage.ERROR_MSG_ID_MODULO -> {
                // Should never happen
                logger.error(session.marker, "ERROR_MSG_ID_MODULO for ${badMessage.badMsgId}")
            }
            else -> logger.error(session.marker, "Unknown error ${badMessage.toPrettyString()}")
        }
    }

    @Throws(IOException::class)
    private fun handleResult(result: MTRpcResult) {
        logger.debug(session.marker, "Got result for msgId ${result.messageId}")

        val subscriber =
                if (subscriberMap.containsKey(result.messageId)) {
                    subscriberMap.remove(result.messageId)!!
                } else {
                    logger.warn(session.marker, "No subscriber found for msgId ${result.messageId}")
                    null
                }

        val request =
                if (requestMap.containsKey(result.messageId)) {
                    requestMap.remove(result.messageId)!!
                } else {
                    logger.warn(session.marker,
                                "No request object found for msgId ${result.messageId}")
                    null
                }

        val classId = StreamUtils.readInt(result.content)
        logger.debug(session.marker, "Response is a $classId")
        if (mtProtoContext.isSupportedObject(classId)) {
            val resultContent = mtProtoContext.deserializeMessage(result.content)
            if (resultContent is MTRpcError) {
                logger.error(session.marker,
                             "rpcError ${resultContent.errorCode}: ${resultContent.message}")
                subscriber?.onError(RpcErrorException(resultContent.errorCode,
                                                      resultContent.errorTag))
            } else
                logger.error(session.marker, "Unsupported content $result")
        } else {
            val response =
                    if (request != null)
                        request.deserializeResponse(result.content, apiContext)
                    else apiContext.deserializeMessage(result.content)
            if (request != null) {
                request.response = response
                subscriber?.onNext(request)
            }
        }

        if (subscriber != null && !subscriberMap.containsValue(subscriber))
            subscriber.onCompleted()
    }

    companion object {

        private val logger = LoggerFactory.getLogger(MTProtoHandler::class.java)!!

        private val mtProtoContext = MTProtoContext
        private val apiContext = TLApiContext.getInstance()

        /** Thread pool to forward update callback */
        private val updatePool = ThreadPoolExecutor(4, 8,
                                                    0L, TimeUnit.MILLISECONDS,
                                                    LinkedBlockingQueue<Runnable>(),
                                                    NamedThreadFactory("UpdatePool"))

        @JvmStatic val QUEUE_TYPE_DISCARD = 0
        //@JvmStatic val QUEUE_TYPE_FLUSH = 1

        /** Shutdown all the threads and common resources associated to this instance */
        @JvmStatic
        fun shutdown() {
            logger.warn("shutdown()")
            MTProtoWatchdog.shutdown()
            MTProtoTimer.shutdown()
        }
    }

    private data class QueuedMethod<T : TLObject?>(val method: TLMethod<T>, val validityTimeout: Long, val subscriber: Subscriber<in TLMethod<T>>)
}
