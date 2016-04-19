package com.github.badoualy.telegram.tl.core;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.TLObjectUtils;
import com.github.badoualy.telegram.tl.exception.InvalidConstructorIdException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * Basic class for all tl-objects. Contains methods for serializing and deserializing object.
 * Each tl-object has its own class id to identify object class for deserialization.
 * This number might be unique and often equals to crc32 of tl-record of tl-constructor.
 * See more at <a href="https://core.telegram.org/mtproto/TL">https://core.telegram.org/mtproto/TL</a>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLObject implements Serializable {

    /**
     * @return the constructor id represented by this class
     */
    public abstract int getConstructorId();

    /**
     * Serialize object to byte array
     *
     * @return serialized object with header
     * @throws IOException
     */
    public final byte[] serialize() throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream(computeSerializedSize());
        serialize(stream);
        return stream.toByteArray();
    }

    /**
     * Serialize object to stream
     *
     * @param stream destination stream
     * @throws IOException
     */
    public final void serialize(OutputStream stream) throws IOException {
        writeInt(getConstructorId(), stream);
        serializeBody(stream);
    }

    /**
     * Deserialize object from stream and current TLContext
     *
     * @param stream  source stream
     * @param context tl context
     * @throws IOException
     */
    public final void deserialize(InputStream stream, TLContext context) throws IOException {
        int constructorId = readInt(stream);
        if (constructorId != getConstructorId())
            throw new InvalidConstructorIdException(constructorId, getConstructorId());
        deserializeBody(stream, context);
    }

    /**
     * Serialize object body to stream
     *
     * @param stream destination stream
     * @throws IOException
     */
    public void serializeBody(OutputStream stream) throws IOException {

    }

    /**
     * Deserialize object from stream and context
     *
     * @param stream  source stream
     * @param context tl context
     * @throws IOException
     */
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

    }

    /**
     * Compute the size in bytes of the serialized object
     *
     * @return size in bytes
     */
    public int computeSerializedSize() {
        return TLObjectUtils.SIZE_CONSTRUCTOR_ID; // Constructor is 4-byte (int32)
    }

    /**
     * Throw an exception to notify that the field trying to be serialized is null
     *
     * @param fieldName name of the field trying to be serialized
     * @param flags flags field current value
     * @throws NullPointerException
     */
    protected final void throwNullFieldException(String fieldName, int flags) throws NullPointerException {
        throw new NullPointerException("Attempt to serialize null field " + fieldName + ", flags = " + flags);
    }
}
