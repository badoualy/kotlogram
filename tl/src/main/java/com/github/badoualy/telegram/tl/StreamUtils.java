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
 * TODO: refactor to extensions?
 */
public final class StreamUtils {

    private StreamUtils() {

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
