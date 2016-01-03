package com.github.badoualy.telegram.tl;

import java.io.IOException;

public class DeserializeException extends IOException {
    public DeserializeException() {
    }

    public DeserializeException(String s) {
        super(s);
    }

    public DeserializeException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DeserializeException(Throwable throwable) {
        super(throwable);
    }
}
