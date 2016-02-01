package com.github.badoualy.telegram.tl.exception;

public class InvalidConstructorIdException extends DeserializationException {

    public InvalidConstructorIdException(int foundId, int expectedId) {
        super("Wrong class id. Found " + Integer.toHexString(foundId)
                      + ", expected: " + Integer.toHexString(expectedId));
    }
}
