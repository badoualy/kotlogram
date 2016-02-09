package com.github.badoualy.telegram.tl.core;

import java.util.Arrays;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TLBytes))
            return false;
        if (this == obj)
            return true;

        // TODO: Arrays.equals on offset/length only...
        TLBytes o = (TLBytes) obj;
        return offset == o.offset
                && len == o.len
                && Arrays.equals(data, o.data);
    }
}