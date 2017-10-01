package com.github.badoualy.telegram.mtproto.log

import org.slf4j.MarkerFactory

data class LogTag(val name: String) {
    val marker = MarkerFactory.getMarker(name)!!
}