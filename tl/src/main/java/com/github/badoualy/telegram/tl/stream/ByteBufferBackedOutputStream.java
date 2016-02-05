package com.github.badoualy.telegram.tl.stream;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedOutputStream extends OutputStream {

    private ByteBuffer buffer;

    public ByteBufferBackedOutputStream(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void write(int b) throws IOException {
        buffer.put((byte) b);
    }

    @Override
    public void write(byte[] bytes, int off, int len) throws IOException {
        buffer.put(bytes, off, len);
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }
}
