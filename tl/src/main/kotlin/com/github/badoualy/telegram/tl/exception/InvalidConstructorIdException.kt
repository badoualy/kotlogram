package com.github.badoualy.telegram.tl.exception

class InvalidConstructorIdException : DeserializationException {
    constructor(foundId: Int, expectedId: Int) : super("Invalid constructor id. Found ${Integer.toHexString(
            foundId)}, expected: ${Integer.toHexString(expectedId)}")

    constructor(message: String) : super(message)
}
