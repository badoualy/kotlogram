package com.github.badoualy.telegram.sample

import com.github.badoualy.telegram.api.Kotlogram
import com.github.badoualy.telegram.sample.config.Config
import com.github.badoualy.telegram.sample.config.FileApiStorage
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException
import java.util.*

object SignInSample {

    @JvmStatic fun main(args: Array<String>) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        val client = Kotlogram.getDefaultClient(Config.application, FileApiStorage())

        // You can start making requests
        try {
            // Send code to account
            val sentCode = client.authSendCode(false, Config.phoneNumber, true)
            println("Authentication code: ")
            val code = Scanner(System.`in`).nextLine()

            // Auth with the received code
            val authorization =
                    try {
                        client.authSignIn(Config.phoneNumber, sentCode.phoneCodeHash, code)
                    } catch (e: RpcErrorException) {
                        if (e.tag.equals("SESSION_PASSWORD_NEEDED", true)) {
                            // We receive this error is two-step auth is enabled
                            println("Two-step auth password: ")
                            val password = Scanner(System.`in`).nextLine()
                            client.authCheckPassword(password)
                        } else throw e
                    }

            authorization.user.asUser.apply {
                println("You are now signed in as $firstName $lastName @$username")
            }
        } catch (e: RpcErrorException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            client.close() // Important, do not forget this, or your process won't finish
        }
    }

}