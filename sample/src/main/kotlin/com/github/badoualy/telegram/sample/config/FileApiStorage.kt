package com.github.badoualy.telegram.sample.config

import com.github.badoualy.telegram.api.TelegramApiStorage
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.model.MTSession
import com.github.badoualy.telegram.sample.config.Config.AUTH_KEY_FILE
import com.github.badoualy.telegram.sample.config.Config.NEAREST_DC_FILE
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class FileApiStorage : TelegramApiStorage {

    override fun saveAuthKey(authKey: AuthKey) = AUTH_KEY_FILE.tryWrite {
        it.writeBytes(authKey.key)
    }

    override fun loadAuthKey() = AUTH_KEY_FILE.tryRead {
        AuthKey(it.readBytes())
    }

    override fun saveDc(dataCenter: DataCenter) = NEAREST_DC_FILE.tryWrite {
        it.writeText(dataCenter.toString())
    }

    override fun loadDc() = NEAREST_DC_FILE.tryRead {
        val fields = it.readText().split(":")
        DataCenter(fields[0], fields[1].toInt())
    }

    override fun deleteAuthKey() = AUTH_KEY_FILE.tryWrite { FileUtils.forceDelete(it) }

    override fun deleteDc() = NEAREST_DC_FILE.tryWrite { FileUtils.forceDelete(it) }

    override fun saveSession(session: MTSession?) {

    }

    override fun loadSession() = null

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
