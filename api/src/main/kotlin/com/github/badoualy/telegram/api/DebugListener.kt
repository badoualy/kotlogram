package com.github.badoualy.telegram.api

public interface DebugListener {

    fun onSocketConnected()

    fun onTimeoutBeforeReset()

    fun onTimeoutAfterReset()

}