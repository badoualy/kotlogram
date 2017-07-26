package com.github.badoualy.telegram.mtproto.auth


import com.github.badoualy.telegram.mtproto.exception.AuthorizationException
import com.github.badoualy.telegram.mtproto.exception.FingerprintNotFoundException
import com.github.badoualy.telegram.mtproto.exception.SecurityException
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.secure.CryptoUtils.*
import com.github.badoualy.telegram.mtproto.secure.Key
import com.github.badoualy.telegram.mtproto.secure.RandomUtils
import com.github.badoualy.telegram.mtproto.secure.pq.PQSolver
import com.github.badoualy.telegram.mtproto.time.TimeOverlord
import com.github.badoualy.telegram.mtproto.tl.auth.*
import com.github.badoualy.telegram.mtproto.transport.MTProtoConnection
import com.github.badoualy.telegram.mtproto.transport.MTProtoTcpConnection
import com.github.badoualy.telegram.mtproto.util.Pair
import com.github.badoualy.telegram.mtproto.util.SolvedPQ
import com.github.badoualy.telegram.tl.StreamUtils
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import org.slf4j.LoggerFactory
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.math.BigInteger
import java.util.*

/**
 * Helper class to execute the "Creating an Authorization Key" flow
 * @see [Creating an Authorization Key](https://core.telegram.org/mtproto/auth_key)
 */
object AuthKeyCreation {

    private val logger = LoggerFactory.getLogger(AuthKeyCreation::class.java)

    private val AUTH_ATTEMPT_COUNT = 5
    private val AUTH_RETRY_COUNT = 5
    private val TEMPORARY_KEY_DEFAULT_EXPIRE_DELAY = 24 * 60 * 60 // 24 hours

    private var connection: MTProtoConnection? = null
    private val authContext = TLAuthContext
    private var tmpKeyExpireDelay = TEMPORARY_KEY_DEFAULT_EXPIRE_DELAY

    /**
     * Create a permanent authorization key
     * @return an object containing the auth key, the connection created, and the server salt received, or null if the creation failed
     * @see [Creating an Authorization Key](https://core.telegram.org/mtproto/auth_key)
     */
    @JvmStatic @JvmOverloads
    fun createAuthKey(dataCenter: DataCenter, tag: String = RandomUtils.randomInt().toString()) = createAuthKeyInternal(dataCenter, false, tag)

    /**
     * Create a temporary authorization key
     * Note: You should bind this key to your permanent key
     * @param expireDelay the delay (in seconds) before the key is invalidated (it may be invalited before by Telegram's server)
     * @return an object containing the auth key, the connection created, and the server salt received, or null if the creation failed
     * @see [Creating an Authorization Key](https://core.telegram.org/mtproto/auth_key)
     * and [Perfect Forward Secrecy](https://core.telegram.org/api/pfs)
     */
    //@JvmStatic @JvmOverloads
    private fun createTmpAuthKey(dataCenter: DataCenter, expireDelay: Int = TEMPORARY_KEY_DEFAULT_EXPIRE_DELAY) {
        tmpKeyExpireDelay = expireDelay
        createAuthKeyInternal(dataCenter, true, "")
    }

    private fun createAuthKeyInternal(dataCenter: DataCenter, tmpKey: Boolean, tag: String): AuthResult? {
        val start = System.currentTimeMillis()
        for (i in 0..AUTH_ATTEMPT_COUNT - 1) {
            try {
                connection = MTProtoTcpConnection(dataCenter.ip, dataCenter.port, tag)
                val authResult = createKey(tmpKey)
                logger.debug(connection!!.marker, "Key created after ${i + 1} attempt in ${System.currentTimeMillis() - start} ms")
                connection = null
                return authResult
            } catch (e: FingerprintNotFoundException) {
                try {
                    connection?.close()
                } catch (e1: IOException) {
                    e1.printStackTrace()
                }

                e.printStackTrace()
            } catch (e: IOException) {
                try {
                    connection?.close()
                } catch (e1: IOException) {
                    e1.printStackTrace()
                }

                e.printStackTrace()
                Thread.sleep(500)
            }
        }

        logger.error(connection!!.marker, "Key creation failed $AUTH_ATTEMPT_COUNT times")
        connection = null
        return null
    }

    /**
     * Send unencrypted message
     * @see [Unencrypted message](https://core.telegram.org/mtproto/description.unencrypted-message)
     * // TODO: move some place else
     */
    @Throws(IOException::class)
    private fun <T : TLObject> executeMethod(method: TLMethod<T>): T {
        val requestMessageId = TimeOverlord.generateMessageId(connection!!.dataCenter)
        val data = method.serialize()

        // @see https://core.telegram.org/mtproto/description#unencrypted-message
        val out = ByteArrayOutputStream()
        StreamUtils.writeLong(0L, out)  // auth_key_id
        StreamUtils.writeLong(requestMessageId, out) // message_id
        StreamUtils.writeInt(data.size, out) // message_data_length
        StreamUtils.writeByteArray(data, out) // message_data
        val response = connection!!.executeMethod(out.toByteArray())

        val inputStream = ByteArrayInputStream(response)
        val authId = StreamUtils.readLong(inputStream)
        if (authId == 0L) {
            @Suppress("UNUSED_VARIABLE")
            val messageId = StreamUtils.readLong(inputStream)
            val length = StreamUtils.readInt(inputStream)
            val messageResponse = StreamUtils.readBytes(length, inputStream)
            return method.deserializeResponse(messageResponse, authContext)
        } else
            throw IOException("Auth id must be equal to zero")
    }

    /** see https://core.telegram.org/mtproto/auth_key#presenting-proof-of-work-server-authentication  */
    @Throws(IOException::class)
    private fun createStep4Request(resPQ: ResPQ, pq: SolvedPQ, publicKey: Key, tmpKey: Boolean): Pair<ReqDhParams, ByteArray> {
        val newNonce = RandomUtils.randomInt256()
        val pqInnerData = if (tmpKey)
            PQInnerTemp(resPQ.pq, fromBigInt(pq.p), fromBigInt(pq.q),
                    resPQ.nonce, resPQ.serverNonce, newNonce, tmpKeyExpireDelay)
        else
            PQInner(resPQ.pq, fromBigInt(pq.p), fromBigInt(pq.q),
                    resPQ.nonce, resPQ.serverNonce, newNonce)

        val data = pqInnerData.serialize()
        val hash = SHA1(data)
        val paddingSize = 255 - (data.size + hash.size)
        val padding = if (paddingSize > 0) RandomUtils.randomByteArray(paddingSize) else ByteArray(0)
        val dataWithHash = concat(hash, data, padding)
        val encryptedData = RSA(dataWithHash, publicKey.publicKey, publicKey.exponent)

        val reqDhParams = ReqDhParams(resPQ.nonce, resPQ.serverNonce,
                fromBigInt(pq.p), fromBigInt(pq.q), publicKey.fingerprint,
                encryptedData)
        return Pair.create(reqDhParams, newNonce)
    }

    /** see https://core.telegram.org/mtproto/auth_key#dh-key-exchange-complete  */
    @Throws(IOException::class)
    private fun lastStep(resPQ: ResPQ, newNonce: ByteArray, serverDhOk: ServerDhOk, @Suppress("UNUSED_PARAMETER") step4Duration: Long): Pair<ByteArray, Long> {
        val encryptedAnswer = serverDhOk.encryptedAnswer
        val tmpAesKey = concat(SHA1(newNonce, resPQ.serverNonce), substring(SHA1(resPQ.serverNonce, newNonce), 0, 12))
        val tmpAesIv = concat(concat(substring(SHA1(resPQ.serverNonce, newNonce), 12, 8),
                SHA1(newNonce, newNonce)),
                substring(newNonce, 0, 4))

        val answer = AES256IGEDecrypt(encryptedAnswer, tmpAesIv, tmpAesKey)
        val stream = ByteArrayInputStream(answer)
        val answerHash = StreamUtils.readBytes(20, stream) // Hash
        val dhInner = authContext.deserializeMessage(stream) as ServerDhInner
        if (!Arrays.equals(answerHash, SHA1(dhInner.serialize()))) {
            throw SecurityException()
        }

        TimeOverlord.setServerTime(connection!!.dataCenter, dhInner.serverTime * 1000L)

        for (i in 0..AUTH_RETRY_COUNT - 1) {
            val b = loadBigInt(RandomUtils.randomByteArray(256))
            val g = BigInteger(dhInner.g.toString())
            val dhPrime = loadBigInt(dhInner.dhPrime)
            val gb = g.modPow(b, dhPrime)

            val authKeyVal = loadBigInt(dhInner.g_a).modPow(b, dhPrime)
            val authKey = alignKeyZero(fromBigInt(authKeyVal), 256) // Step7
            val authAuxHash = substring(SHA1(authKey), 0, 8) // Step8

            val clientDHInner = ClientDhInner(resPQ.nonce, resPQ.serverNonce, i.toLong(), fromBigInt(gb))
            val innerData = clientDHInner.serialize()
            val innerDataWithHash = align(concat(SHA1(innerData), innerData), 16)
            val dataWithHashEnc = AES256IGEEncrypt(innerDataWithHash, tmpAesIv, tmpAesKey)

            // Step6
            val result = executeMethod(ReqSetDhClientParams(resPQ.nonce, resPQ.serverNonce, dataWithHashEnc))

            // Step9
            if (result is DhGenOk) {
                val newNonceHash = substring(SHA1(newNonce, byteArrayOf(1), authAuxHash), 4, 16)

                if (!Arrays.equals(result.newNonceHash, newNonceHash))
                    throw SecurityException()

                val serverSalt = StreamUtils.readLong(xor(substring(newNonce, 0, 8), substring(resPQ.serverNonce, 0, 8)), 0)

                return Pair(authKey, serverSalt)
            } else if (result is DhGenRetry) {
                logger.warn(connection!!.marker, "Received ${result.javaClass.simpleName}")
                val newNonceHash = substring(SHA1(newNonce, byteArrayOf(2), authAuxHash), 4, 16)

                if (!Arrays.equals(result.newNonceHash, newNonceHash))
                    throw SecurityException()
            } else if (result is DhGenFailure) {
                logger.warn(connection!!.marker, "Received ${result.javaClass.simpleName}")
                val newNonceHash = substring(SHA1(newNonce, byteArrayOf(3), authAuxHash), 4, 16)

                if (!Arrays.equals(result.newNonceHash, newNonceHash))
                    throw SecurityException()

                throw AuthorizationException()
            }
        }

        throw AuthorizationException()
    }

    /** For details about the protocol, see https://core.telegram.org/mtproto/auth_key  */
    @Throws(IOException::class, FingerprintNotFoundException::class)
    private fun createKey(tmpKey: Boolean): AuthResult {
        logger.debug(connection!!.marker, "Attempting to create a " + (if (tmpKey) "temporary " else "permanent") + " Authorization Key")

        // Step 1
        val nonce = RandomUtils.randomInt128() // int128
        val resPQ = executeMethod(ReqPQ(nonce))
        logger.trace(connection!!.marker, "Got resPQ with " + resPQ.fingerprints.size + " fingerprints")
        logger.trace(connection!!.marker, "Step1 done")

        // Step 2
        val publicKey = Arrays.stream(Key.AVAILABLE_KEYS).filter { k ->
            resPQ.fingerprints.contains(k.fingerprint)
        }.findFirst().orElseThrow { FingerprintNotFoundException(resPQ.fingerprints.joinToString(", ")) }
        logger.trace(connection!!.marker, "Step2 done")

        // Step 3
        val solvedPQ = PQSolver.solve(BigInteger(1, resPQ.pq))
        logger.trace(connection!!.marker, "Step3 done")

        // Step 4
        val pair = createStep4Request(resPQ, solvedPQ, publicKey, tmpKey)
        val reqDhParams = pair.first
        val newNonce = pair.second
        logger.trace(connection!!.marker, "Step4 request created")

        val start = System.nanoTime()
        val dhParams = executeMethod(reqDhParams)
        val step4Duration = (System.nanoTime() - start) / (1000 * 1000)
        logger.trace(connection!!.marker, "Step4 done")

        // Step 5
        if (dhParams is ServerDhFailure) {
            if (Arrays.equals(dhParams.newNonceHash, SHA1(newNonce))) {
                throw AuthorizationException("Received " + dhParams.toString())
            } else {
                throw SecurityException("Received " + dhParams.toString() + " with incorrect hash")
            }
        }

        val serverDhParams = dhParams as ServerDhOk
        logger.trace(connection!!.marker, "Step5 done")

        // -------------------------
        // PQ-Auth end
        // DH-Auth start
        // -------------------------
        val keySaltPair = lastStep(resPQ, newNonce, serverDhParams, step4Duration)

        logger.trace(connection!!.marker, "Step6 to 9 done")
        val authKey = if (!tmpKey)
            AuthKey(keySaltPair.first)
        else
            TempAuthKey(keySaltPair.first, TimeOverlord.getServerTime(connection!!.dataCenter).toInt() + tmpKeyExpireDelay)
        return AuthResult(authKey, keySaltPair.second, connection!!)
    }
}
