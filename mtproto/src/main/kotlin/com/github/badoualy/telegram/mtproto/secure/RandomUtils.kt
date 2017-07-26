package com.github.badoualy.telegram.mtproto.secure

import java.math.BigInteger
import java.security.SecureRandom

class RandomUtils {

    companion object {

        private val random = SecureRandom()

        init {
            random.setSeed(System.currentTimeMillis())
        }

        @JvmStatic @Synchronized fun randomByteArray(byteCount: Int): ByteArray {
            val byteArray = ByteArray(byteCount)
            random.nextBytes(byteArray)
            return byteArray
        }

        @JvmStatic @Synchronized fun randomInt() = random.nextInt()

        /**
         * @return a (random) 64-bit byte array
         * @see [MTProto description](https://core.telegram.org/mtproto/description.session)
         */
        @JvmStatic @Synchronized fun randomSessionId() = randomByteArray(8)

        /** @return a (random) 64-bit long number */
        @JvmStatic @Synchronized fun randomLong() = BigInteger(randomByteArray(8)).toLong()

        /** @return a (random) int128 */
        @JvmStatic @Synchronized fun randomInt128() = randomByteArray(16)

        /** @return a (random) int256 */
        @JvmStatic @Synchronized fun randomInt256() = randomByteArray(32)
    }
}