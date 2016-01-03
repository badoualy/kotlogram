package com.github.badoualy.telegram.mtproto.secure

import java.math.BigInteger
import java.security.SecureRandom

class RandomUtils {

    companion object {

        private val random = SecureRandom()

        init {
            random.setSeed(System.currentTimeMillis())
        }

        @JvmStatic @Synchronized fun randomByteArray(byteCount: Int) = random.generateSeed(byteCount)

        @JvmStatic @Synchronized fun randomInt() = random.nextInt()

        @JvmStatic @Synchronized fun setSeed(data: ByteArray) = random.setSeed(data)

        /**
         * @return a (random) 64-bit byte array
         * @see [MTProto description](https://core.telegram.org/mtproto/description.session)
         */
        @JvmStatic @Synchronized fun randomSessionId() = random.generateSeed(8)

        /** @return a (random) 64-bit long number */
        @JvmStatic @Synchronized fun randomLong() = BigInteger(random.generateSeed(8)).longValueExact()

        /** @return a (random) int128 */
        @JvmStatic @Synchronized fun randomInt128() = random.generateSeed(16)

        /** @return a (random) int256 */
        @JvmStatic @Synchronized fun randomInt256() = random.generateSeed(32)
    }
}