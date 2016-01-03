package com.github.badoualy.telegram.mtproto

data class DataCenter constructor(val ip: String, val port: Int) {
    override fun toString() = "$ip:$port"
}