package com.github.badoualy.telegram.tl;

import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Helper class for writing and reading data for tl (de-)serialization.
 */
public final class StreamUtils {

    private StreamUtils() {

    }

    public static void writeByte(int v, OutputStream stream) throws IOException {
        stream.write(v);
    }

    public static void writeByte(byte v, OutputStream stream) throws IOException {
        stream.write(v);
    }

    public static void writeByteArray(byte[] data, OutputStream stream) throws IOException {
        stream.write(data);
    }

    public static void writeByteArray(byte[] data, int offset, int len, OutputStream stream) throws IOException {
        stream.write(data, offset, len);
    }

    /**
     * Write the given int in little endian format as 4 bytes
     */
    public static void writeInt(int v, OutputStream stream) throws IOException {
        writeByte((byte) (v & 0xFF), stream);
        writeByte((byte) ((v >> 8) & 0xFF), stream);
        writeByte((byte) ((v >> 16) & 0xFF), stream);
        writeByte((byte) ((v >> 24) & 0xFF), stream);
    }

    /**
     * Write the given long in little endian format as 8 bytes
     */
    public static void writeLong(long v, OutputStream stream) throws IOException {
        writeByte((byte) (v & 0xFF), stream);
        writeByte((byte) ((v >> 8) & 0xFF), stream);
        writeByte((byte) ((v >> 16) & 0xFF), stream);
        writeByte((byte) ((v >> 24) & 0xFF), stream);

        writeByte((byte) ((v >> 32) & 0xFF), stream);
        writeByte((byte) ((v >> 40) & 0xFF), stream);
        writeByte((byte) ((v >> 48) & 0xFF), stream);
        writeByte((byte) ((v >> 56) & 0xFF), stream);
    }

    public static void writeDouble(double v, OutputStream stream) throws IOException {
        writeLong(Double.doubleToRawLongBits(v), stream);
    }

    public static void writeBoolean(boolean v, OutputStream stream) throws IOException {
        TLBool.serialize(v, stream);
    }

    public static void writeString(String v, OutputStream stream) throws IOException {
        writeTLBytes(v.getBytes(Charset.forName("UTF-8")), stream);
    }

    /**
     * Write the given bytes in the stream, prefixing with the length.
     */
    public static void writeTLBytes(byte[] v, OutputStream stream) throws IOException {
        int startOffset = 1;
        if (v.length >= 254) {
            startOffset = 4;
            writeByte(254, stream);
            writeByte(v.length & 0xFF, stream);
            writeByte((v.length >> 8) & 0xFF, stream);
            writeByte((v.length >> 16) & 0xFF, stream);
        } else {
            writeByte(v.length, stream);
        }

        writeByteArray(v, stream);

        int offset = (v.length + startOffset) % 4;
        if (offset != 0) {
            int offsetCount = 4 - offset;
            writeByteArray(new byte[offsetCount], stream);
        }
    }

    public static void writeTLBytes(TLBytes v, OutputStream stream) throws IOException {
        int startOffset = 1;
        if (v.getLength() >= 254) {
            startOffset = 4;
            writeByte(254, stream);
            writeByte(v.getLength() & 0xFF, stream);
            writeByte((v.getLength() >> 8) & 0xFF, stream);
            writeByte((v.getLength() >> 16) & 0xFF, stream);
        } else {
            writeByte(v.getLength(), stream);
        }

        writeByteArray(v.getData(), v.getOffset(), v.getLength(), stream);

        int offset = (v.getLength() + startOffset) % 4;
        if (offset != 0) {
            int offsetCount = 4 - offset;
            writeByteArray(new byte[offsetCount], stream);
        }
    }

    public static void writeTLObject(TLObject v, OutputStream stream) throws IOException {
        v.serialize(stream);
    }

    public static void writeTLMethod(TLMethod v, OutputStream stream) throws IOException {
        writeTLObject(v, stream);
    }

    public static void writeTLVector(TLVector v, OutputStream stream) throws IOException {
        writeTLObject(v, stream);
    }

    public static int readByte(InputStream stream) throws IOException {
        int a = stream.read();
        if (a < 0)
            throw new IOException();
        return a;
    }

    public static int readInt(InputStream stream) throws IOException {
        int a = stream.read();
        if (a < 0)
            throw new IOException();
        int b = stream.read();
        if (b < 0)
            throw new IOException();
        int c = stream.read();
        if (c < 0)
            throw new IOException();
        int d = stream.read();
        if (d < 0)
            throw new IOException();

        return a + (b << 8) + (c << 16) + (d << 24);
    }

    public static long readUInt(InputStream stream) throws IOException {
        long a = stream.read();
        if (a < 0) {
            throw new IOException();
        }
        long b = stream.read();
        if (b < 0) {
            throw new IOException();
        }
        long c = stream.read();
        if (c < 0) {
            throw new IOException();
        }
        long d = stream.read();
        if (d < 0) {
            throw new IOException();
        }

        return a + (b << 8) + (c << 16) + (d << 24);
    }

    public static long readLong(InputStream stream) throws IOException {
        long a = readUInt(stream);
        long b = readUInt(stream);

        return a + (b << 32);
    }
    public static double readDouble(InputStream stream) throws IOException {
        return Double.longBitsToDouble(readLong(stream));
    }

    public static String readTLString(InputStream stream) throws IOException {
        return new String(readTLBytes(stream), "UTF-8");
    }

    public static TLObject readTLObject(InputStream stream, TLContext context) throws IOException {
        return context.deserializeMessage(stream);
    }

    public static <T extends TLObject> T readTLObject(InputStream stream, TLContext context, Class<T> clazz, int constructorId) throws IOException {
        return context.deserializeMessage(stream, clazz, constructorId);
    }

    public static TLMethod readTLMethod(InputStream stream, TLContext context) throws IOException {
        return (TLMethod) context.deserializeMessage(stream);
    }

    public static byte[] readBytes(int count, InputStream stream) throws IOException {
        byte[] res = new byte[count];
        int offset = 0;
        while (offset < res.length) {
            int read = stream.read(res, offset, res.length - offset);
            if (read > 0) {
                offset += read;
            } else if (read < 0) {
                throw new IOException();
            } else {
                Thread.yield();
            }
        }
        return res;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void skipBytes(int count, InputStream stream) throws IOException {
        // Skipping with skip() on a gzip stream is buggy when reached end of stream
        // stream.skip(count);
        readBytes(count, stream);
    }

    public static void readBytes(byte[] buffer, int offset, int count, InputStream stream) throws IOException {
        int woffset = 0;
        while (woffset < count) {
            int read = stream.read(buffer, woffset + offset, count - woffset);
            if (read > 0) {
                woffset += read;
            } else if (read < 0) {
                throw new IOException();
            } else {
                Thread.yield();
            }
        }
    }

    public static byte[] readTLBytes(InputStream stream) throws IOException {
        int count = stream.read();
        int startOffset = 1;
        if (count >= 254) {
            count = stream.read() + (stream.read() << 8) + (stream.read() << 16);
            startOffset = 4;
        }

        byte[] raw = readBytes(count, stream);
        int offset = (count + startOffset) % 4;
        if (offset != 0) {
            int offsetCount = 4 - offset;
            skipBytes(offsetCount, stream);
        }

        return raw;
    }

    public static TLBytes readTLBytes(InputStream stream, TLContext context) throws IOException {
        int count = stream.read();
        int startOffset = 1;
        if (count >= 254) {
            count = stream.read() + (stream.read() << 8) + (stream.read() << 16);
            startOffset = 4;
        }

        TLBytes res = new TLBytes(new byte[count], 0, count);
        readBytes(res.getData(), res.getOffset(), res.getLength(), stream);

        int offset = (count + startOffset) % 4;
        if (offset != 0) {
            int offsetCount = 4 - offset;
            skipBytes(offsetCount, stream);
        }
        return res;
    }

    public static TLVector readTLVector(InputStream stream, TLContext context) throws IOException {
        return context.deserializeVector(stream);
    }

    public static TLIntVector readTLIntVector(InputStream stream, TLContext context) throws IOException {
        return context.deserializeIntVector(stream);
    }

    public static TLLongVector readTLLongVector(InputStream stream, TLContext context) throws IOException {
        return context.deserializeLongVector(stream);
    }

    public static TLStringVector readTLStringVector(InputStream stream, TLContext context) throws IOException {
        return context.deserializeStringVector(stream);
    }

    public static boolean readTLBool(InputStream stream) throws IOException {
        return TLBool.deserialize(stream);
    }

    public static byte[] intToBytes(int value) {
        return new byte[]{(byte) (value & 0xFF),
                          (byte) ((value >> 8) & 0xFF),
                          (byte) ((value >> 16) & 0xFF),
                          (byte) ((value >> 24) & 0xFF)};
    }

    public static byte[] longToBytes(long value) {
        return new byte[]{(byte) (value & 0xFF),
                          (byte) ((value >> 8) & 0xFF),
                          (byte) ((value >> 16) & 0xFF),
                          (byte) ((value >> 24) & 0xFF),
                          (byte) ((value >> 32) & 0xFF),
                          (byte) ((value >> 40) & 0xFF),
                          (byte) ((value >> 48) & 0xFF),
                          (byte) ((value >> 56) & 0xFF)};
    }

    public static int readInt(byte[] src) {
        return readInt(src, 0);
    }

    public static int readInt(byte[] src, int offset) {
        int a = src[offset] & 0xFF;
        int b = src[offset + 1] & 0xFF;
        int c = src[offset + 2] & 0xFF;
        int d = src[offset + 3] & 0xFF;

        return a + (b << 8) + (c << 16) + (d << 24);
    }

    public static long readUInt(byte[] src) {
        return readUInt(src, 0);
    }

    public static long readUInt(byte[] src, int offset) {
        long a = src[offset] & 0xFF;
        long b = src[offset + 1] & 0xFF;
        long c = src[offset + 2] & 0xFF;
        long d = src[offset + 3] & 0xFF;

        return a + (b << 8) + (c << 16) + (d << 24);
    }

    @SuppressWarnings("PointlessBitwiseExpression")
    public static long readLong(byte[] src, int offset) {
        long a = readUInt(src, offset);
        long b = readUInt(src, offset + 4);

        return (a & 0xFFFFFFFF) + ((b & 0xFFFFFFFF) << 32);
    }

    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String toHexString(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

}
