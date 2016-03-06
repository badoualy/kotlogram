package com.github.badoualy.telegram.tl.exception;

public class RpcErrorException extends Exception {

    private final int code;
    private final String tag;

    public RpcErrorException(int code, String tag) {
        super(code + ": " + tag);
        this.code = code;
        this.tag = tag;
    }

    public int getCode() {
        return code;
    }

    public String getTag() {
        return tag;
    }
}
