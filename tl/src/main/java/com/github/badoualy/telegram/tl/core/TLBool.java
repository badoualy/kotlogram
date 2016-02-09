package com.github.badoualy.telegram.tl.core;

import com.github.badoualy.telegram.tl.exception.InvalidConstructorIdException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLBool extends TLObject {

    public static final TLBool TRUE = new TLBoolTrue();
    public static final TLBool FALSE = new TLBoolFalse();

    public static final int TRUE_CONSTRUCTOR_ID = TLBoolTrue.CONSTRUCTOR_ID;
    public static final int FALSE_CONSTRUCTOR_ID = TLBoolFalse.CONSTRUCTOR_ID;

    public static TLBool get(boolean value) {
        return value ? TRUE : FALSE;
    }

    public static void serialize(boolean value, OutputStream stream) throws IOException {
        get(value).serialize(stream);
    }

    public static boolean deserialize(InputStream stream) throws IOException {
        int constructorId = readInt(stream);
        if (constructorId == TLBoolTrue.CONSTRUCTOR_ID)
            return true;
        if (constructorId == TLBoolFalse.CONSTRUCTOR_ID)
            return false;

        throw new InvalidConstructorIdException("Wrong TLBool constructor id. Found " + Integer.toHexString(constructorId)
                                                        + ", expected: " + Integer.toHexString(TLBoolTrue.CONSTRUCTOR_ID)
                                                        + " or " + Integer.toHexString(TLBoolFalse.CONSTRUCTOR_ID));
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj; // Singleton, 1 instance
    }

    private static final class TLBoolTrue extends TLBool {

        public static final int CONSTRUCTOR_ID = 0x997275b5;

        private TLBoolTrue() {

        }

        @Override
        public int getConstructorId() {
            return CONSTRUCTOR_ID;
        }

        @Override
        public String toString() {
            return "boolTrue#997275b5";
        }
    }

    private static final class TLBoolFalse extends TLBool {

        public static final int CONSTRUCTOR_ID = 0xbc799737;

        private TLBoolFalse() {

        }

        @Override
        public int getConstructorId() {
            return CONSTRUCTOR_ID;
        }

        @Override
        public String toString() {
            return "boolFalse#bc799737";
        }
    }

}
