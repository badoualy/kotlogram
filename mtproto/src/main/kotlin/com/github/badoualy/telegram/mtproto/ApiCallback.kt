package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.tl.api.TLAbsUpdates

interface ApiCallback {
    fun onUpdates(update: TLAbsUpdates)
}