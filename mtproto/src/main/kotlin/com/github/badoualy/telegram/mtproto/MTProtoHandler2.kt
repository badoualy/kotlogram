package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.exception.AuthKeyInvalidException
import com.github.badoualy.telegram.mtproto.exception.ContainerInvalidException
import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.log.Logger
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.model.MTSession
import com.github.badoualy.telegram.mtproto.net.MTProtoConnection
import com.github.badoualy.telegram.mtproto.net.MTProtoConnectionFactory
import com.github.badoualy.telegram.mtproto.net.MTProtoTcpConnectionFactory
import com.github.badoualy.telegram.mtproto.secure.MTProtoMessageEncryption
import com.github.badoualy.telegram.mtproto.time.MTProtoTimer
import com.github.badoualy.telegram.mtproto.time.TimeOverlord
import com.github.badoualy.telegram.mtproto.tl.*
import com.github.badoualy.telegram.mtproto.util.NamedThreadFactory
import com.github.badoualy.telegram.tl.StreamUtils
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLApiContext
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import com.github.badoualy.telegram.tl.serialization.TLStreamDeserializer
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.ofType
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.io.ByteArrayInputStream
import java.io.IOException
import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class MTProtoHandler2 {

    private var connection: MTProtoConnection
    var authKey: AuthKey
        private set
    var session: MTSession
        private set

    private val messageSubject: Subject<Pair<MTProtoMessage, TLObject>> = PublishSubject.create()

    private val requestByIdMap = Hashtable<Long, TLMethod<*>>(10)
    private val sentMessageList = ArrayList<MTProtoMessage>(10)
    private var ackBuffer = MTBuffer<Long>(ACK_BUFFER_SIZE, ACK_BUFFER_TIMEOUT, TimeUnit.SECONDS)

    val tag: LogTag
        get() = session.tag

    constructor(authResult: AuthResult) {
        authKey = authResult.authKey
        connection = authResult.connection
        session = newSession(connection.dataCenter)
        session.salt = authResult.serverSalt
        connection.tag = session.tag
        ackBuffer.tag = session.tag
        logger.debug(tag, "Created from auth result")
    }

    @Throws(IOException::class)
    constructor(dataCenter: DataCenter, authKey: AuthKey, session: MTSession?) {
        this.authKey = authKey
        this.session = session ?: newSession(dataCenter)
        connection = connectionFactory.create(dataCenter.ip, dataCenter.port, this.session.tag)
        ackBuffer.tag = this.session.tag
        logger.debug(tag, "Created from existing key (new session? ${session == null}}")
    }

    fun startSubscription() {
        logger.info(tag, "startWatchdog()")
        connection.getMessageObservable()
                .observeOn(Schedulers.computation())
                .flatMap(flatMapMessage())
                .map(deserializePayload())
                .subscribe(messageSubject)

        messageSubject
                .subscribeBy(onNext = onMessageReceived(),
                             onError = {
                                 logger.error(tag, "messageSubject onErrorReceived()", it)
                             },
                             onComplete = {
                                 logger.warn(tag, "messageSubject onComplete()")
                                 messageSubject.onComplete()
                             })

        ackBuffer.observable
                .map {
                    logger.info(tag, "ackBuffer emitted ${it.joinToString()}")
                    newAckMessage(it)
                }
                .observeOn(Schedulers.io())
                .subscribeBy(onNext = { sendMessage(it) })
    }

    private fun stopSubscription() {
        messageSubject.onComplete()
    }

    /** Close the connection and re-open another one, should fix most connection issues */
    @Throws(IOException::class)
    fun resetConnection() {
        logger.warn(session.tag, "resetConnection()")
        close()

        // TODO: maybe we could keep the session, and handle seqno difference
        session = newSession(connection.dataCenter)
        connection = connectionFactory.create(connection.ip, connection.port, session.tag)
        startSubscription()
    }

    fun close() {
        logger.info(tag, "close()")
        ackBuffer.dispose()
        stopSubscription()
        connection.close()

        sentMessageList.clear()
        requestByIdMap.clear()
    }

    fun <T : TLObject> executeMethodSync(method: TLMethod<T>): T =
            executeMethod(method).blockingGet()

    fun <T : TLObject> executeMethodsSync(methods: List<TLMethod<T>>): List<T> =
            executeMethods(methods).blockingIterable().toList()

    // TODO: single() without error?
    @Suppress("UNCHECKED_CAST")
    fun <T : TLObject> executeMethod(method: TLMethod<T>): Single<T> =
            executeMethods(listOf(method)).singleOrError()

    fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>): Observable<T> =
            methods.takeIf { it.isNotEmpty() }?.let {
                messageSubject
                        .map { it.second }
                        .ofType<MTRpcResult>()
                        .filter { methods.contains(requestByIdMap[it.messageId]) } // TODO: check null
                        .take(methods.size.toLong())
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe { executeMethods_(methods) }
                        .observeOn(Schedulers.computation())
                        .flatMapMaybe(mapResult())
                        .map { it as T }
            } ?: Observable.empty<T>()


    private fun executeMethods_(methods: List<TLMethod<*>>) {
        logger.trace("executeMethods ${methods.joinToString { it.toString() }}")

        val messages = ArrayList<MTProtoMessage>(methods.size)

        // Methods
        methods.mapTo(messages) { newMethodMessage(it) }

        // Add ACK messages
        messages.add(getAckMessage())

        // Queue method
        messages.addAll(getQueuedToSend())

        val message =
                if (messages.size > 1) {
                    logger.trace("Sending container with ${messages.size} items")
                    newMessage(MTMessagesContainer(messages))
                } else {
                    logger.trace(tag, "Sending only one message")
                    messages.first()
                }

        sendMessage(message)
    }

    @Throws(IOException::class)
    private fun sendMessage(message: MTProtoMessage) {
        logger.debug(tag,
                     "Sending message with msgId ${message.messageId} and seqNo ${message.seqNo}")

        val encryptedMessage = MTProtoMessageEncryption.generateEncryptedMessage(authKey,
                                                                                 session.id,
                                                                                 session.salt,
                                                                                 message)

        connection.sendMessage(encryptedMessage.data)
        sentMessageList.add(message)
    }

    @Throws(IOException::class)
    private fun resendMessage(messageId: Long, updateMessageId: Boolean) {
        logger.info("resendMessage $messageId")

        val sentMessage = sentMessageList.firstOrNull { it.messageId == messageId }
        if (sentMessage != null) {
            if (updateMessageId) {
                // Update map and generate new msgId
                val request = requestByIdMap.remove(sentMessage.messageId)
                sentMessage.messageId = session.generateMessageId()
                requestByIdMap.put(sentMessage.messageId, request)
            }

            logger.debug(tag,
                         "Re-sending message $messageId with msgId ${sentMessage.messageId}")
            sendMessage(sentMessage)
        } else {
            logger.error(tag, "Couldn't find sentMessage in history with msgId $messageId")
        }
    }

    /**
     * Transforms a received message (network message) into an Observable of [MTProtoMessage].
     * Data received from Telegram can be a [MTMessagesContainer] containing multiple [MTProtoMessage].
     * This function will map the data received into an observable emitting 1 item per [MTProtoMessage].
     *
     * - If the message payload is a container, the observable will emit each contained messages
     * - If the message payload is not a container, the observable will emit the message
     * - If the AUTH_KEY_INVALID error is received, an [AuthKeyInvalidException] will be thrown
     * - If any other error occurs at some point, the observable will emit nothing
     *
     * @return an observable emitting zero to multiple [MTProtoMessage], each being guaranteed to not be a [MTMessagesContainer].
     */
    @Throws(AuthKeyInvalidException::class)
    private fun flatMapMessage(): (ByteArray) -> Observable<MTProtoMessage> = { bytes: ByteArray ->
        if (bytes.size == 4)
            throw AuthKeyInvalidException(StreamUtils.readInt(bytes))

        try {
            val message = MTProtoMessageEncryption.extractMessage(authKey, session.id, bytes)
            logger.debug(tag, "Received msg ${message.messageId} with seqNo ${message.seqNo}")

            when (StreamUtils.readInt(message.payload)) {
                MTMessagesContainer.CONSTRUCTOR_ID -> {
                    val tlDeserializer = TLStreamDeserializer(message.payload, mtProtoContext)
                    val container = tlDeserializer.readTLObject(MTMessagesContainer::class,
                                                                MTMessagesContainer.CONSTRUCTOR_ID)
                    logger.trace(tag, "Container has ${container.messages.size} items")

                    // Ensure valid container
                    container.messages.toList().foldRight(message.messageId, { m, id ->
                        m.messageId.takeIf { it < id } ?: throw ContainerInvalidException(container)
                    })

                    container.messages.toObservable()
                }
                else -> Observable.just(message)
            }
        } catch (e: Exception) {
            // This is not a terminal event, don't kill observable
            logger.error(tag, "Error while extracting message", e)
            Observable.empty<MTProtoMessage>()
        }
    }

    private fun deserializePayload(): (MTProtoMessage) -> Pair<MTProtoMessage, TLObject> = { message ->
        val classId = StreamUtils.readInt(message.payload)
        logger.trace(session.tag, "Payload constructor id: $classId")

        val context =
                if (mtProtoContext.contains(classId)) {
                    logger.trace(tag, "$classId is supported by MTProtoContext")
                    mtProtoContext
                } else {
                    logger.trace(tag, "$classId is not supported by MTProtoContext")
                    apiContext
                }

        val payload = TLStreamDeserializer(ByteArrayInputStream(message.payload),
                                           context).readTLObject<TLObject>()

        Pair(message, payload)
    }

    @Throws(IOException::class)
    private fun onMessageReceived(): (Pair<MTProtoMessage, TLObject>) -> Unit = { (message, payload) ->
        logger.debug(tag, "handle $payload")

        when (payload) {
            is MTMsgsAck -> {
                // TODO: MessageACK will not get an ack, it'll stack here...
                sentMessageList.removeAll { payload.messages.contains(it.messageId) }
                logger.debug(tag, "Received ack for ${payload.messages.joinToString()}")
                // TODO check missing ack ?
            }
            is MTRpcResult -> {
                queueMessageAck(message.messageId)
            }
            is TLAbsUpdates -> {
                queueMessageAck(message.messageId)
            }
            is MTNewSessionCreated -> {
                //session.salt = messageContent.serverSalt
                queueMessageAck(message.messageId)
            }
            is MTBadMessageNotification -> {
                handleBadMessage(payload, message)
            }
            is MTBadServerSalt -> {
                logger.error(tag, payload.toPrettyString())

                // Message contains a good salt to use
                session.salt = payload.newSalt
                resendMessage(payload.badMsgId, false)
            }
            is MTNeedResendMessage -> {
                logger.warn(tag, "TODO MTNeedResendMessage")
                // TODO
            }
            is MTNewMessageDetailedInfo -> {
                logger.warn(tag, "TODO MTNewMessageDetailedInfo")
                // TODO
            }
            is MTMessageDetailedInfo -> {
                logger.warn(tag, "TODO MTMessageDetailedInfo")
                // TODO
            }
            is MTFutureSalts -> {
                logger.warn(tag, "TODO MTFutureSalts")
                // TODO
            }
            else -> {
                logger.error(tag,
                             "Unsupported constructor in handleMessage() $payload: ${payload.javaClass.simpleName}")
            }
        }
    }

    private fun mapResult(): (MTRpcResult) -> Maybe<out TLObject> = { result ->
        logger.debug(tag, "Got result for msgId ${result.messageId}")

        val request =
                if (requestByIdMap.containsKey(result.messageId)) {
                    requestByIdMap.remove(result.messageId)!!
                } else {
                    logger.warn(tag, "No request found for msgId ${result.messageId}")
                    null
                }

        val clazzId = StreamUtils.readInt(result.content)
        logger.trace(tag, "Response constructor id: $clazzId")

        // TODO change TLStreamDeserializer instantiation, factory?

        val resultObject = when {
            mtProtoContext.contains(clazzId) -> {
                val content = TLStreamDeserializer(result.content, mtProtoContext)
                        .readTLObject<TLObject>()
                if (content is MTRpcError) {
                    logger.error(tag,
                                 "rpcError ${content.errorCode}: ${content.message}")
                    throw RpcErrorException(content.errorCode, content.errorTag)
                } else {
                    logger.error(tag, "Unsupported content $content")
                    null
                }
            }
            request != null -> request.deserializeResponse(result.content, apiContext)
            else -> {
                // Fallback, this will error if object is a non-TLObject vector (int, long, String)
                logger.warn(tag, "Attempting to deserialize without knowing the type")
                TLStreamDeserializer(result.content, apiContext).readTLObject()
            }
        }

        resultObject?.let { Maybe.just(it) } ?: Maybe.empty<TLObject>()
    }

    @Throws(IOException::class)
    private fun handleBadMessage(badMessage: MTBadMessageNotification, container: MTProtoMessage) {
        logger.error(tag, badMessage.toPrettyString())

        when (badMessage.errorCode) {
            MTBadMessage.ERROR_MSG_ID_TOO_LOW, MTBadMessage.ERROR_MSG_ID_TOO_HIGH -> {
                session.lastMessageId = 0
                TimeOverlord.synchronizeTime(connection.dataCenter, container.messageId)

                // Resend message with good id
                resendMessage(badMessage.badMsgId, true)
            }
            MTBadMessage.ERROR_SEQNO_TOO_LOW, MTBadMessage.ERROR_SEQNO_TOO_HIGH -> {
                // TODO: should probably use badMessage.badMsgSeqno
                if (badMessage.errorCode == MTBadMessage.ERROR_MSG_ID_TOO_LOW)
                    session.contentRelatedCount++
                else
                    session.contentRelatedCount--

                // Resend message with good seqno
                resendMessage(badMessage.badMsgId, true)
            }
            MTBadMessage.ERROR_SEQNO_EXPECTED_EVEN -> {
                // Should never happen
                logger.error(tag, "ERROR_SEQNO_EXPECTED_EVEN for ${badMessage.badMsgId}")
            }
            MTBadMessage.ERROR_SEQNO_EXPECTED_ODD -> {
                // Should never happen
                logger.error(tag, "ERROR_SEQNO_EXPECTED_ODD for ${badMessage.badMsgId}")
            }
            MTBadMessage.ERROR_MSG_ID_MODULO -> {
                // Should never happen
                logger.error(tag, "ERROR_MSG_ID_MODULO for ${badMessage.badMsgId}")
            }
            else -> logger.error(tag, "Unknown error ${badMessage.toPrettyString()}")
        }
    }

    private fun queueMessageAck(id: Long) {
        ackBuffer.add(id)
    }

    private fun getAckMessage(): MTProtoMessage = newAckMessage(ackBuffer.get())

    private fun getQueuedToSend(): List<MTProtoMessage> {
        // TODO
        return emptyList()
    }

    private fun newSession(dataCenter: DataCenter) = MTSession(dataCenter).also {
        logger.info(it.tag, "New session created")
    }

    private fun newAckMessage(idList: List<Long>) = newMessage(MTMsgsAck(idList.toLongArray()))

    private fun newMethodMessage(method: TLMethod<*>) = newMessage(method).also {
        logger.trace(tag, "Sending $method with msgId ${it.messageId} and seqNo ${it.seqNo}")
        requestByIdMap.put(it.messageId, method)
    }

    private fun newMessage(payload: TLObject) = MTProtoMessage(session.generateMessageId(),
                                                               session.generateSeqNo(payload),
                                                               payload.serialize())

    companion object {

        private val logger = Logger(MTProtoHandler2::class)

        private const val ACK_BUFFER_SIZE = 30
        private const val ACK_BUFFER_TIMEOUT = 5L

        private val mtProtoContext = MTProtoContext
        private val apiContext = TLApiContext

        /** Thread pool to forward update callback */
        // TODO: check values
        private val updatePool = ThreadPoolExecutor(4, 8,
                                                    0L, TimeUnit.MILLISECONDS,
                                                    LinkedBlockingQueue<Runnable>(),
                                                    NamedThreadFactory("UpdatePool"))

        private val connectionFactory: MTProtoConnectionFactory = MTProtoTcpConnectionFactory()

        /**
         * Shutdown all the threads and resources associated to this instance.
         * Calling this method will prevent further handlers from being created/used properly.
         */
        @JvmStatic
        fun shutdown() {
            logger.warn("shutdown()")
            MTProtoWatchdog.shutdown()
            MTProtoTimer.shutdown()
        }
    }
}