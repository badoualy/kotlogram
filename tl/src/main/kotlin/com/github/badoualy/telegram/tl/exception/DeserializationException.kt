package com.github.badoualy.telegram.tl.exception

import java.io.IOException

open class DeserializationException(s: String) : IOException(s)