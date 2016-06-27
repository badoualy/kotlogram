package com.github.badoualy.telegram.tl;

import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.nio.charset.Charset;

public final class TLObjectUtils {

    private TLObjectUtils() {

    }

    public static int SIZE_INT32 = 4;
    public static int SIZE_CONSTRUCTOR_ID = SIZE_INT32;
    public static int SIZE_BOOLEAN = SIZE_CONSTRUCTOR_ID;
    public static int SIZE_INT64 = 8;
    public static int SIZE_DOUBLE = 8;

    public static int computeTLBytesSerializedSize(int length) {
        int size = length + (length >= 254 ? 4 : 1);
        int offset = size % 4;
        if (offset != 0)
            size += 4 - offset; // Padding
        return size;
    }

    public static int computeTLBytesSerializedSize(TLBytes bytes) {
        return computeTLBytesSerializedSize(bytes.getLength());
    }

    public static int computeTLStringSerializedSize(String string) {
        return computeTLBytesSerializedSize(string.getBytes(Charset.forName("UTF-8")).length);
    }

    /**
     * Checks if the given object is content-related (useful for seqNo generation)
     * @param clazz object type to check
     * @return true if the object is content related, else false
     */
    public static boolean isContentRelated(Class<? extends TLObject> clazz){
        return !clazz.getSimpleName().startsWith("MT");
    }

    public static <T extends TLObject> boolean isContentRelated(T object){
        return isContentRelated(object.getClass());
    }
}
