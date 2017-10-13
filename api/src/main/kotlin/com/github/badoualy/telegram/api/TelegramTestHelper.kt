package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.secure.RandomUtils

object TelegramTestHelper {

    fun generatePhoneNumber(dcId: Int) =
            generatePhoneNumber(dcId, String.format("%04d", RandomUtils.randomInt() % 10000))

    fun generatePhoneNumber(dcId: Int, number: String) = "99966$dcId$number"

    fun getValidationCode(number: String) = number.removePrefix("+")[5].let { dcId ->
        CharArray(5, { dcId }).joinToString("")
    }
}