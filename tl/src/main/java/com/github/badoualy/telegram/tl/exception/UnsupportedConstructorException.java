package com.github.badoualy.telegram.tl.exception;

public class UnsupportedConstructorException extends DeserializationException {

    public UnsupportedConstructorException(int constructorId) {
        super("Unsupported constructor: #" + Integer.toHexString(constructorId));
    }
}
