package com.github.badoualy.telegram.mtproto.secure

import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.secure.CryptoUtils.*
import com.github.badoualy.telegram.mtproto.tl.MTMessage
import com.github.badoualy.telegram.mtproto.util.AesKeyIvPair
import com.github.badoualy.telegram.tl.StreamUtils
import com.github.badoualy.telegram.tl.StreamUtils.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

/**
 * Helper class to handle the encryption/decryption of message following the MTProto protocol description
 */
class MTProtoMessageEncryption {

    companion object {
        /**
         * Generate message key
         * The lower-order 128 bits of the SHA1 hash of the part of the message to be encrypted (including the internal header and excluding the alignment bytes).
         * @param unencryptedData concatenation of the data to be encrypted (without padding)
         * @return message key
         * @see [Message Key](https://core.telegram.org/mtproto/description.message-key)
         */
        @JvmStatic fun generateMsgKey(unencryptedData: ByteArray) = substring(SHA1(unencryptedData), 4, 16)


        /**
         * Generate message key for the given message
         * @param serverSalt server salt used
         * @param sessionId session id used
         * @param message concerned message
         * @return The lower-order 128 bits of the SHA1 hash of the part of the message to be encrypted
         * @see [Message Key](https://core.telegram.org/mtproto/description.message-key)
         */
        @JvmStatic fun generateMsgKey(serverSalt: ByteArray, sessionId: ByteArray, message: MTMessage): ByteArray? {
            try {
                val crypt = MessageDigest.getInstance("SHA-1")
                crypt.reset()
                crypt.update(serverSalt)
                crypt.update(sessionId)
                crypt.update(longToBytes(message.messageId))
                crypt.update(intToBytes(message.seqNo))
                crypt.update(intToBytes(message.payloadLength))
                crypt.update(message.payload, 0, message.payloadLength) // Use len as payload may have padding
                return substring(crypt.digest(), 4, 16)
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }

            return null
        }

        /**
         * Encrypt a message following the MTProto description
         * @see [MTProto description](https://core.telegram.org/mtproto/description)

         * @param authKey authKey to use to encrypt
         * @param sessionId session id used
         * @param serverSalt server salt used
         * @param message message to be encrypted
         * @return encrypted message containing the encryption and the origin message
         * @throws IOException
         */
        @Throws(IOException::class)
        @JvmStatic
        fun encrypt(authKey: AuthKey, sessionId: ByteArray, serverSalt: Long, message: MTMessage): EncryptedMessage {
            // Build message body
            val unencryptedStream = ByteArrayOutputStream()
            writeLong(serverSalt, unencryptedStream)
            writeByteArray(sessionId, unencryptedStream)
            writeLong(message.messageId, unencryptedStream)
            writeInt(message.seqNo, unencryptedStream)
            writeInt(message.payload.size, unencryptedStream)
            writeByteArray(message.payload, unencryptedStream)

            val unencryptedData = unencryptedStream.toByteArray()
            val msgKey = generateMsgKey(unencryptedData)

            // Encrypt data
            val aesKeyIvPair = computeAESKeyAndInitVector(authKey, msgKey, 0)
            val encryptedData = AES256IGEEncrypt(align(unencryptedData, 16), aesKeyIvPair.iv, aesKeyIvPair.key)

            // Auth key is 8 bytes, Message key is 16
            val out = ByteArrayOutputStream(24 + encryptedData.size)
            writeByteArray(authKey.keyId, out)
            writeByteArray(msgKey, out)
            writeByteArray(encryptedData, out)

            return EncryptedMessage(message, out.toByteArray())
        }

        /**
         * Decrypt a message following the MTProto description
         * @see [MTProto description](https://core.telegram.org/mtproto/description)

         * @param authKey authKey to use to encrypt
         * @param sessionId session id used
         * @param data message to be decrypted
         * @return decrypted message
         * @throws IOException
         */
        @Throws(IOException::class)
        @JvmStatic
        fun decrypt(authKey: AuthKey, sessionId: ByteArray, data: ByteArray): MTMessage {
            val stream = ByteArrayInputStream(data)

            // Retrieve and check authKey
            val msgAuthKeyId = readBytes(8, stream)
            if (!Arrays.equals(authKey.keyId, msgAuthKeyId))
                throw RuntimeException("Message's authKey doesn't match given authKey")

            // Message key
            val msgKey = readBytes(16, stream)
            val aesKeyIvPair = computeAESKeyAndInitVector(authKey, msgKey, 8)

            // Read encrypted data
            val encryptedDataLength = data.size - 24 // Subtract authKey(8) + msgKey(16) length
            val encryptedData = ByteArray(encryptedDataLength)
            readBytes(encryptedData, 0, encryptedDataLength, stream)

            // Decrypt
            val unencryptedData = ByteArray(encryptedDataLength) // AES input/output have the same size
            AES256IGEDecryptBig(encryptedData, unencryptedData, encryptedDataLength, aesKeyIvPair.iv, aesKeyIvPair.key)

            // Decompose
            val unencryptedStream = ByteArrayInputStream(unencryptedData)
            val serverSalt = readBytes(8, unencryptedStream)
            val session = readBytes(8, unencryptedStream)
            // Payload starts here
            val msgId = readLong(unencryptedStream)
            val seqNo = StreamUtils.readInt(unencryptedStream)
            val msgLength = StreamUtils.readInt(unencryptedStream)
            val paddingSize = encryptedDataLength - 32 - msgLength // serverSalt(8) + sessionId(8) + messageId(8) + seqNo(4) + msgLen(4)

            // Security checks
            if (msgId % 2 == 0L) throw SecurityException("Message id of messages sent be the server must be odd, found $msgId")
            if (msgLength % 4 != 0) throw SecurityException("Message length must be a multiple of 4, found $msgLength")
            if (paddingSize > 15 || paddingSize < 0) throw SecurityException("Padding must be between 0 and 15 included, found $paddingSize")
            if (!Arrays.equals(session, sessionId)) throw SecurityException("The message was not intended for this session, expected ${BigInteger(sessionId).toLong()}, found ${BigInteger(session).toLong()}")

            // Read message
            val message = ByteArray(msgLength)
            readBytes(message, 0, msgLength, unencryptedStream)

            val mtMessage = MTMessage(msgId, seqNo, message, message.size)

            // Check that msgKey is equal to the 128 lower-order bits of the SHA1 hash of the previously encrypted portion
            val checkMsgKey = generateMsgKey(serverSalt, session, mtMessage)
            if (!Arrays.equals(checkMsgKey, msgKey))
                throw SecurityException("The message msgKey is inconsistent with it's data")

            return mtMessage
        }

        /**
         * Compute the AES Key and the Initialization Vector

         * @param x x = 0 for messages from client to server and x = 8 for those from server to client.
         * @see [Defining AES Key and Initialization Vector](https://core.telegram.org/mtproto/description.defining-aes-key-and-initialization-vector)
         */
        @JvmStatic
        private fun computeAESKeyAndInitVector(authKey: AuthKey, msgKey: ByteArray, x: Int): AesKeyIvPair {
            val sha1_a = CryptoUtils.SHA1(msgKey, substring(authKey.key, x, 32))
            val sha1_b = CryptoUtils.SHA1(substring(authKey.key, 32 + x, 16), msgKey, substring(authKey.key, 48 + x, 16))
            val sha1_c = CryptoUtils.SHA1(substring(authKey.key, 64 + x, 32), msgKey)
            val sha1_d = CryptoUtils.SHA1(msgKey, substring(authKey.key, 96 + x, 32))

            val aesKey = concat(substring(sha1_a, 0, 8), substring(sha1_b, 8, 12), substring(sha1_c, 4, 12))
            val aesIv = concat(substring(sha1_a, 8, 12), substring(sha1_b, 0, 8), substring(sha1_c, 16, 4), substring(sha1_d, 0, 8))

            return AesKeyIvPair(aesKey, aesIv)
        }
    }
}