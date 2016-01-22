package com.github.badoualy.telegram.tl.core;

public class TLBytes {
    private byte[] data;
    private int offset;
    private int len;

    public TLBytes(byte[] data) {
        this.data = data;
        this.offset = 0;
        this.len = data.length;
    }

    public TLBytes(byte[] data, int offset, int len) {
        this.data = data;
        this.offset = offset;
        this.len = len;
    }

    public byte[] getData() {
        return data;
    }

    public int getOffset() {
        return offset;
    }

    public int getLength() {
        return len;
    }

    public byte[] cleanData() {
        if (offset == 0 && len == data.length) {
            return data;
        }
        byte[] result = new byte[len];
        System.arraycopy(data, offset, result, 0, len);
        return result;
    }
}
