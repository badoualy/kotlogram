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

    @Override
    public String toString() {
        return getMessage();
    }

    /**
     * Parse the tag to extract the integer value at the end (ex: FILE_MIGRATE_X, FLOOD_WAIT_X, ...)
     *
     * @return extracted integer value
     */
    public Integer getTagInteger() {
        String[] chunks = tag.split("_");
        return Integer.parseInt(chunks[chunks.length - 1]);
    }
}
