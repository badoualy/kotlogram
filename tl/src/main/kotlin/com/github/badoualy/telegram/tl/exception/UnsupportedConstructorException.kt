package com.github.badoualy.telegram.tl.exception

class UnsupportedConstructorException(constructorId: Int) :
        DeserializationException("Unsupported constructor: #" + Integer.toHexString(constructorId))
