package com.github.badoualy.telegram.tl.core;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.exception.InvalidConstructorIdException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * Basic class for all tl-objects. Contains methods for serializing and deserializing object.<br/>
 * Each tl-object has its own class id to identify object class for deserialization.<br/>
 * This number might be unique and often equals to crc32 of tl-record of tl-constructor.<br/>
 * See more at <a href="https://core.telegram.org/mtproto/TL">https://core.telegram.org/mtproto/TL</a><br/>
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
     * Serializing object to byte array
     *
     * @return serialized object with header
     * @throws IOException
     */
    public byte[] serialize() throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        serialize(stream);
        return stream.toByteArray();
    }

    /**
     * Serializing object to stream
     *
     * @param stream destination stream
     * @throws IOException
     */
    public void serialize(OutputStream stream) throws IOException {
        writeInt(getConstructorId(), stream);
        serializeBody(stream);
    }

    /**
     * Deserializing object from stream and current TLContext
     *
     * @param stream  source stream
     * @param context tl context
     * @throws IOException
     */
    public void deserialize(InputStream stream, TLContext context) throws IOException {
        int classId = readInt(stream);
        if (classId != getConstructorId())
            throw new InvalidConstructorIdException(classId, getConstructorId());
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
}
