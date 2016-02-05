package com.github.badoualy.telegram.tl;

import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ByteBufferUtils {

    private static final ByteOrder order = ByteOrder.LITTLE_ENDIAN;

    private ByteBufferUtils() {

    }

    public static byte readByte(ByteBuffer buffer) throws IOException {
        return buffer.get();
    }

    public static int readByteAsInt(ByteBuffer buffer) throws IOException {
        return Byte.toUnsignedInt(buffer.get());
    }

    public static void readBytes(byte[] dest, int offset, int length, ByteBuffer buffer) throws IOException {
        buffer.get(dest, offset, length);
    }

    public static byte[] readBytes(int length, ByteBuffer buffer) throws IOException {
        byte[] bytes = new byte[length];
        buffer.get(bytes);
        return bytes;
    }

    /**
     * Read as little endian by default
     */
    public static int readInt(ByteBuffer buffer) throws IOException {
        byte[] values = new byte[4];
        buffer.get(values);
        ByteBuffer value = ByteBuffer.wrap(values);
        value.order(order);
        return value.getInt();
    }

    public static int readInt24(ByteBuffer buffer) throws IOException {
        byte[] values = new byte[4];
        values[3] = 0;
        buffer.get(values, 0, 3); // Read 3 bytes
        ByteBuffer value = ByteBuffer.wrap(values);
        value.order(ByteOrder.LITTLE_ENDIAN);
        return value.getInt();
    }

    /**
     * Read as little endian by default
     */
    public static long readLong(ByteBuffer buffer) throws IOException {
        byte[] values = new byte[8];
        buffer.get(values);
        ByteBuffer value = ByteBuffer.wrap(values);
        value.order(order);
        return value.getLong();
    }

    public static double readDouble(ByteBuffer buffer) throws IOException {
        return Double.longBitsToDouble(readLong(buffer));
    }

    public static TLBytes readTLBytes(ByteBuffer buffer) throws IOException {
        int length = readByteAsInt(buffer);

        // see https://core.telegram.org/mtproto/serialize#base-types
        if (length == 254)
            length = readInt24(buffer);

        byte[] bytes = readBytes(length, buffer);
        int offset = (length + (length <= 253 ? 1 : 4)) % 4;
        if (offset > 0)
            buffer.position(buffer.position() + (4 - offset));

        return new TLBytes(bytes, 0, length);
    }

    public static String readTLString(ByteBuffer buffer) throws IOException {
        return new String(readTLBytes(buffer).getData(), "UTF-8");
    }

//    public static TLObject readTLObject(ByteBuffer buffer, TLContext context) throws IOException {
//        return context.deserializeMessage(buffer);
//    }
//
//    public static TLMethod readTLMethod(ByteBuffer buffer, TLContext context) throws IOException {
//        return (TLMethod) context.deserializeMessage(buffer);
//    }
//
//    public static TLVector readTLVector(ByteBuffer buffer, TLContext context) throws IOException {
//        return context.deserializeVector(buffer);
//    }
//
//    public static TLIntVector readTLIntVector(ByteBuffer buffer, TLContext context) throws IOException {
//        return context.deserializeIntVector(buffer);
//    }
//
//    public static TLLongVector readTLLongVector(ByteBuffer buffer, TLContext context) throws IOException {
//        return context.deserializeLongVector(buffer);
//    }
//
//    public static TLStringVector readTLStringVector(ByteBuffer buffer, TLContext context) throws IOException {
//        return context.deserializeStringVector(buffer);
//    }
//
//    public static boolean readTLBool(ByteBuffer buffer) throws IOException {
//        return TLBool.deserialize(buffer);
//    }

}