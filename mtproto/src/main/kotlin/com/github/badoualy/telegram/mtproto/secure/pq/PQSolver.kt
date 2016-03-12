package com.github.badoualy.telegram.mtproto.secure.pq

import com.github.badoualy.telegram.mtproto.util.SolvedPQ
import java.math.BigInteger
import java.util.*

internal class PQSolver {

    companion object {
        /**
         * Decomposes pq into prime factors such that p < q
         * Same implementation than https://github.com/enricostara/telegram-mt-node/blob/master/lib/security/pq-finder.js
         * TODO: check origin
         */
        @JvmStatic
        @SuppressWarnings("SuspiciousNameCombination")
        fun solve(input: BigInteger): SolvedPQ {
            val r = Random()
            val pq = input.toLong()
            var q: Long = 0
            for (i in 0..2) {
                val w = (r.nextInt(128) and 15) + 17
                var x = (r.nextInt(1000000000) + 1).toLong()
                var y = x

                val lim = 1 shl (i + 18)
                for (j in 1..lim - 1) {
                    var a = x
                    var b = x
                    var c = w.toLong()
                    while (b != 0L) {
                        if ((b and 1) != 0L) {
                            c += a
                            if (c >= pq) {
                                c -= pq
                            }
                        }
                        a += a
                        if (a >= pq) {
                            a -= pq
                        }
                        b = b shr 1
                    }
                    x = c
                    val z = if (x < y) y - x else x - y // var z = y.gt(x) TODO why different here ?
                    q = GCD(z, pq)
                    if (q != 1L)
                        break
                    if ((j and (j - 1)) == 0)
                        y = x
                }
                if (q > 1)
                    break
            }

            val p = pq / q
            return SolvedPQ(p, q)
        }

        private fun GCD(x: Long, y: Long): Long {
            var a = x
            var b = y
            while (a != 0L && b != 0L) {
                while ((b and 1) == 0L) {
                    b = b shr 1
                }
                while ((a and 1) == 0L) {
                    a = a shr 1
                }
                if (a > b) {
                    a -= b
                } else {
                    b -= a
                }
            }
            return if (b == 0L) a else b
        }
    }
}