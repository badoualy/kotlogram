package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.tl.api.TLAbsUpdates

public interface ApiCallback {
    fun onSalt(salt: Long)

    fun onUpdates(update: TLAbsUpdates)
}