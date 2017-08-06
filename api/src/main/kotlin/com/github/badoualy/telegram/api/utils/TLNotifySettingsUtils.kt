package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings
import com.github.badoualy.telegram.tl.api.TLPeerNotifySettings
import java.util.concurrent.TimeUnit

val TLAbsPeerNotifySettings.isMuted: Boolean
    get() = when (this) {
        is TLPeerNotifySettings -> muteUntil > TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + 60
        else -> false
    }