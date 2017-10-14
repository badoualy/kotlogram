package com.github.badoualy.telegram.sample.config

import com.github.badoualy.telegram.api.Kotlogram
import com.github.badoualy.telegram.api.TelegramApiStorage
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.TempAuthKey
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.model.MTSession
import com.github.badoualy.telegram.sample.config.Config.AUTH_KEY_FILE
import com.github.badoualy.telegram.sample.config.Config.NEAREST_DC_FILE
import com.github.badoualy.telegram.sample.config.Config.TEMP_AUTH_KEY_FILE
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class FileApiStorage : TelegramApiStorage {

    override var authKey: AuthKey?
        get() = AUTH_KEY_FILE.tryRead { AuthKey(it.readBytes()) }
        set(value) {
            if (value != null) {
                AUTH_KEY_FILE.tryWrite {
                    it.writeBytes(value.key)
                }
            } else if (AUTH_KEY_FILE.exists()){
                AUTH_KEY_FILE.tryWrite { FileUtils.forceDelete(it) }
            }
        }

    override var tempAuthKey: TempAuthKey?
        get() = TEMP_AUTH_KEY_FILE.tryRead { TempAuthKey(it.readBytes(), Integer.MAX_VALUE) }
        set(value) {
            if (value != null) {
                TEMP_AUTH_KEY_FILE.tryWrite {
                    it.writeBytes(value.key)
                }
            } else if (TEMP_AUTH_KEY_FILE.exists()){
                TEMP_AUTH_KEY_FILE.tryWrite { FileUtils.forceDelete(it) }
            }
        }

    override var dataCenter: DataCenter?
        get() = NEAREST_DC_FILE.tryRead {
            it.readText().toIntOrNull()?.takeIf { it in 1..5 }?.let { Kotlogram.getDcById(it) }
        }
        set(value) {
            if (value != null) {
                NEAREST_DC_FILE.tryWrite {
                    it.writeText(value.id.toString())
                }
            } else {
                NEAREST_DC_FILE.tryWrite { FileUtils.forceDelete(it) }
            }

        }

    override var session: MTSession?
        get() = null
        set(value) {}

    private fun <T> File.tryRead(block: (File) -> T): T? {
        try {
            return block.invoke(this)
        } catch (e: IOException) {
            if (e !is FileNotFoundException)
                e.printStackTrace()
        }
        return null
    }

    private fun File.tryWrite(block: (File) -> Unit) {
        try {
            block.invoke(this)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
