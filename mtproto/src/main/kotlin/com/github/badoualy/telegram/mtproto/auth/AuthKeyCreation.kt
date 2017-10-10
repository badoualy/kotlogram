package com.github.badoualy.telegram.mtproto.auth


import com.github.badoualy.telegram.mtproto.exception.AuthorizationException
import com.github.badoualy.telegram.mtproto.exception.FingerprintNotFoundException
import com.github.badoualy.telegram.mtproto.exception.SecurityException
import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.log.Logger
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.net.MTProtoConnection
import com.github.badoualy.telegram.mtproto.net.MTProtoTcpConnection
import com.github.badoualy.telegram.mtproto.secure.CryptoUtils.*
import com.github.badoualy.telegram.mtproto.secure.Key
import com.github.badoualy.telegram.mtproto.secure.MTProtoMessageEncryption
import com.github.badoualy.telegram.mtproto.secure.RandomUtils
import com.github.badoualy.telegram.mtproto.secure.pq.PQSolver
import com.github.badoualy.telegram.mtproto.time.TimeOverlord
import com.github.badoualy.telegram.mtproto.tl.auth.*
import com.github.badoualy.telegram.mtproto.util.Pair
import com.github.badoualy.telegram.mtproto.util.SolvedPQ
import com.github.badoualy.telegram.tl.StreamUtils
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLSerializerFactory
import com.github.badoualy.telegram.tl.serialization.TLStreamSerializerFactory
import java.io.IOException
import java.math.BigInteger
import java.util.*

/**
 * Helper class to execute the "Creating an Authorization Key" flow
 * @see [Creating an Authorization Key](https://core.telegram.org/mtproto/auth_key)
 */
object AuthKeyCreation {

    private val logger = Logger(AuthKeyCreation::class)

    /** Total generation retry count */
    private const val AUTH_ATTEMPT_COUNT = 5
    /** Step 6-9 retry count */
    private const val AUTH_RETRY_COUNT = 5
    private const val TEMPORARY_KEY_DEFAULT_EXPIRE_DELAY = 24 * 60 * 60 // 24 hours

    private var connection: MTProtoConnection? = null
    private val context = TLAuthContext
    private const val tmpKeyExpireDelay = TEMPORARY_KEY_DEFAULT_EXPIRE_DELAY
    private val tlSerializerFactory: TLSerializerFactory = TLStreamSerializerFactory

    /**
     * Create a permanent authorization key
     * @return an object containing the auth key, the connection created, and the server salt received, or null if the creation failed
     * @see [Creating an Authorization Key](https://core.telegram.org/mtproto/auth_key)
     */
    fun createAuthKey(dataCenter: DataCenter) = createAuthKeyInternal(dataCenter, false)

    private fun createAuthKeyInternal(dataCenter: DataCenter, tmpKey: Boolean): AuthResult? {
        val start = System.currentTimeMillis()
        for (i in 1..AUTH_ATTEMPT_COUNT) {
            try {
                connection = MTProtoTcpConnection(dataCenter.ip, dataCenter.port,
                                                  LogTag("<unauthorized>"))
                val authResult = createKey(tmpKey)
                logger.debug(connection!!.tag,
                             "Key created after $i attempt in ${System.currentTimeMillis() - start} ms")
                connection = null
                return authResult
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                try {
                    connection?.close()
                } catch (e1: IOException) {
                }
                connection = null
            }

            try {
                Thread.sleep((500 * minOf(i - 1, 1)).toLong())
            } catch (e1: InterruptedException) {
            }
        }

        logger.error("Key creation failed $AUTH_ATTEMPT_COUNT times")
        return null
    }

    /**
     * Send unencrypted message and return response in a sync way
     * @see [Unencrypted message](https://core.telegram.org/mtproto/description.unencrypted-message)
     */
    @Throws(IOException::class)
    private fun <T : TLObject> executeMethod(method: TLMethod<T>): T {
        val requestMessageId = TimeOverlord.generateMessageId(connection!!.dataCenter)
        val data = method.serialize()

        // @see https://core.telegram.org/mtproto/description#unencrypted-message
        val message = MTProtoMessageEncryption.generateUnencryptedMessage(requestMessageId,
                                                                          data)

        val response = connection!!.executeMethodSync(message)
        val responseData = MTProtoMessageEncryption.extractUnencryptedMessage(response)
        return method.deserializeResponse(responseData, context)
    }

    /** For details about the protocol, see https://core.telegram.org/mtproto/auth_key */
    @Throws(IOException::class, FingerprintNotFoundException::class)
    private fun createKey(tmpKey: Boolean): AuthResult {
        logger.debug(connection!!.tag,
                     "Attempting to create a ${if (tmpKey) "temporary " else "permanent"} Authorization Key")

        // Step 1 https://core.telegram.org/mtproto/auth_key#dh-exchange-initiation
        val nonce = RandomUtils.randomInt128() // int128
        val resPQ = executeMethod(ReqPQ(nonce))
        logger.trace(connection!!.tag,
                     "Got resPQ with ${resPQ.fingerprints.size} fingerprints")
        logger.trace(connection!!.tag, "Step1 done")

        // Step 2
        val publicKey = Key.AVAILABLE_KEYS.firstOrNull { k ->
            resPQ.fingerprints.contains(k.fingerprint)
        } ?: throw FingerprintNotFoundException(resPQ.fingerprints.joinToString())
        logger.trace(connection!!.tag, "Step2 done")

        // Step 3 https://core.telegram.org/mtproto/auth_key#proof-of-work
        val solvedPQ = PQSolver.solve(BigInteger(1, resPQ.pq))
        logger.trace(connection!!.tag, "Step3 done")

        // Step 4 https://core.telegram.org/mtproto/auth_key#presenting-proof-of-work-server-authentication
        val pair = createStep4Request(resPQ, solvedPQ, publicKey, tmpKey)
        val reqDhParams = pair.first
        val newNonce = pair.second
        logger.trace(connection!!.tag, "Step4 request created")

        val dhParams = executeMethod(reqDhParams)
        logger.trace(connection!!.tag, "Step4 done")

        // Step 5
        if (dhParams is ServerDhFailure) {
            if (Arrays.equals(dhParams.newNonceHash, SHA1(newNonce))) {
                throw AuthorizationException("Received $dhParams")
            } else {
                throw SecurityException("Received $dhParams with incorrect hash")
            }
        }

        val serverDhParams = dhParams as ServerDhOk
        logger.trace(connection!!.tag, "Step5 done")

        // -------------------------
        // PQ-Auth end
        // DH-Auth start
        // -------------------------
        val keySaltPair = lastStep(resPQ, newNonce, serverDhParams)

        logger.trace(connection!!.tag, "Step6 to 9 done")
        val authKey =
                if (!tmpKey) {
                    AuthKey(keySaltPair.first)
                } else {
                    TempAuthKey(keySaltPair.first,
                                TimeOverlord.getServerTime(
                                        connection!!.dataCenter) + tmpKeyExpireDelay)
                }
        return AuthResult(authKey, keySaltPair.second, connection!!)
    }

    /** see https://core.telegram.org/mtproto/auth_key#presenting-proof-of-work-server-authentication  */
    @Throws(IOException::class)
    private fun createStep4Request(resPQ: ResPQ, pq: SolvedPQ, publicKey: Key, tmpKey: Boolean): Pair<ReqDhParams, ByteArray> {
        val newNonce = RandomUtils.randomInt256()
        val pqInnerData =
                if (tmpKey) {
                    PQInnerTemp(resPQ.pq, fromBigInt(pq.p), fromBigInt(pq.q),
                                resPQ.nonce, resPQ.serverNonce, newNonce, tmpKeyExpireDelay)
                } else {
                    PQInner(resPQ.pq, fromBigInt(pq.p), fromBigInt(pq.q),
                            resPQ.nonce, resPQ.serverNonce, newNonce)
                }

        val data = pqInnerData.serialize()
        val hash = SHA1(data)
        val paddingSize = 255 - (data.size + hash.size)
        val padding = if (paddingSize > 0) RandomUtils.randomByteArray(paddingSize) else ByteArray(
                0)
        val dataWithHash = concat(hash, data, padding)
        val encryptedData = RSA(dataWithHash, publicKey.publicKey, publicKey.exponent)

        val reqDhParams = ReqDhParams(resPQ.nonce, resPQ.serverNonce,
                                      fromBigInt(pq.p), fromBigInt(pq.q), publicKey.fingerprint,
                                      encryptedData)
        return Pair(reqDhParams, newNonce)
    }

    /** see https://core.telegram.org/mtproto/auth_key#dh-key-exchange-complete  */
    @Throws(IOException::class)
    private fun lastStep(resPQ: ResPQ, newNonce: ByteArray, serverDhOk: ServerDhOk): Pair<ByteArray, Long> {
        val encryptedAnswer = serverDhOk.encryptedAnswer
        val tmpAesKey = concat(SHA1(newNonce, resPQ.serverNonce),
                               substring(SHA1(resPQ.serverNonce, newNonce), 0, 12))
        val tmpAesIv = concat(concat(substring(SHA1(resPQ.serverNonce, newNonce), 12, 8),
                                     SHA1(newNonce, newNonce)),
                              substring(newNonce, 0, 4))

        val answer = AES256IGEDecrypt(encryptedAnswer, tmpAesIv, tmpAesKey)
        val tlDeserializer = tlSerializerFactory.createDeserializer(answer, context)
        val answerHash = tlDeserializer.readBytes(20) // Hash
        val dhInner = tlDeserializer.readTLObject<ServerDhInner>()
        if (!Arrays.equals(answerHash, SHA1(dhInner.serialize()))) {
            throw SecurityException("answerHash doesn't match the one generated from dhInner")
        }

        TimeOverlord.setServerTime(connection!!.dataCenter, dhInner.serverTime * 1000L)

        for (i in 0 until AUTH_RETRY_COUNT) {
            val b = loadBigInt(RandomUtils.randomByteArray(256))
            val g = BigInteger(dhInner.g.toString())
            val dhPrime = loadBigInt(dhInner.dhPrime)
            val gb = g.modPow(b, dhPrime)

            val authKeyVal = loadBigInt(dhInner.g_a).modPow(b, dhPrime)
            val authKey = alignKeyZero(fromBigInt(authKeyVal), 256) // Step7
            val authAuxHash = substring(SHA1(authKey), 0, 8) // Step8

            val clientDHInner = ClientDhInner(resPQ.nonce,
                                              resPQ.serverNonce,
                                              i.toLong(),
                                              fromBigInt(gb))
            val innerData = clientDHInner.serialize()
            val innerDataWithHash = align(concat(SHA1(innerData), innerData), 16)
            val dataWithHashEnc = AES256IGEEncrypt(innerDataWithHash, tmpAesIv, tmpAesKey)

            // Step6
            val result = executeMethod(ReqSetDhClientParams(resPQ.nonce,
                                                            resPQ.serverNonce,
                                                            dataWithHashEnc))

            // Step9 https://core.telegram.org/mtproto/auth_key#dh-key-exchange-complete
            if (result is DhGenOk) {
                val newNonceHash = substring(SHA1(newNonce, byteArrayOf(1), authAuxHash), 4, 16)

                if (!Arrays.equals(result.newNonceHash, newNonceHash))
                    throw SecurityException("newNonceHash from result don't match generated one")

                val serverSalt = StreamUtils.readLong(xor(substring(newNonce, 0, 8),
                                                          substring(resPQ.serverNonce, 0, 8)), 0)

                return Pair(authKey, serverSalt)
            } else if (result is DhGenRetry) {
                logger.warn(connection!!.tag, "Received ${result.javaClass.simpleName}")
                val newNonceHash = substring(SHA1(newNonce, byteArrayOf(2), authAuxHash), 4, 16)

                if (!Arrays.equals(result.newNonceHash, newNonceHash))
                    throw SecurityException("newNonceHash from result don't match generated one")
            } else if (result is DhGenFailure) {
                logger.warn(connection!!.tag, "Received ${result.javaClass.simpleName}")
                val newNonceHash = substring(SHA1(newNonce, byteArrayOf(3), authAuxHash), 4, 16)

                if (!Arrays.equals(result.newNonceHash, newNonceHash))
                    throw SecurityException("newNonceHash from result don't match generated one")

                throw AuthorizationException("Received $result")
            }
        }

        throw AuthorizationException("Failed step 6 to 9 after $AUTH_RETRY_COUNT attempts")
    }
}
