package com.github.badoualy.telegram.mtproto.thread

import java.util.concurrent.Executors

internal object MTThreadPool {
    val pool = Executors.newCachedThreadPool()
}