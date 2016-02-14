package com.github.badoualy.telegram.tl.exception;

public class InvalidConstructorIdException extends DeserializationException {

    public InvalidConstructorIdException(int foundId, int expectedId) {
        super("Invalid constructor id. Found " + Integer.toHexString(foundId)
                      + ", expected: " + Integer.toHexString(expectedId));
    }

    public InvalidConstructorIdException(String message) {
        super(message);
    }
}
