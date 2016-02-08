package com.github.badoualy.telegram.api

interface DebugListener {

    fun onSocketCreated()

    fun onTimeoutBeforeReset()

    fun onTimeoutAfterReset()

    fun onSocketDestroyed()
}