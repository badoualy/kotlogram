package com.github.badoualy.telegram.api

public interface DebugListener {

    fun onSocketCreated()

    fun onTimeoutBeforeReset()

    fun onTimeoutAfterReset()

    fun onSocketDestroyed()
}