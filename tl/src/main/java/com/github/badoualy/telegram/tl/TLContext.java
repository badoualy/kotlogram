package com.github.badoualy.telegram.tl;

import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLGzipObject;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
import com.github.badoualy.telegram.tl.core.TLVector;
import com.github.badoualy.telegram.tl.exception.DeserializationException;
import com.github.badoualy.telegram.tl.exception.InvalidConstructorIdException;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

/**
 * TypeLanguage context object. It performs deserialization of objects and vectors.
 * All known classes might be registered in context for deserialization.
 * Often this might be performed from inherited class in init() method call.
 * If TL-Object contains static int field CONSTRUCTOR_ID, then it might be used for registration,
 * but it uses reflection so it might be slow in some cases. It recommended to manually pass CONSTRUCTOR_ID
 * to registerClass method.
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLContext {

    private HashMap<Integer, Class> registeredClasses;

    /**
     * It's recommended to use an initial size for better performances
     */
    @Deprecated
    public TLContext() {
        registeredClasses = new HashMap<>();
        init();
    }

    public TLContext(int size) {
        registeredClasses = new HashMap<>(size);
        init();
    }

    protected abstract void init();

    public boolean isSupportedObject(TLObject object) {
        return isSupportedObject(object.getConstructorId());
    }

    public boolean isSupportedObject(int constructorId) {
        return registeredClasses.containsKey(constructorId);
    }

    public <T extends TLObject> void registerClass(int constructorId, Class<T> clazz) {
        registeredClasses.put(constructorId, clazz);
    }

    public TLObject deserializeMessage(byte[] data) throws IOException {
        return deserializeMessage(new ByteArrayInputStream(data));
    }

    public TLObject deserializeMessage(InputStream stream) throws IOException {
        int constructorId = StreamUtils.readInt(stream);
        return deserializeMessage(constructorId, stream);
    }

    public TLObject deserializeMessage(int constructorId, InputStream stream) throws IOException {
        if (constructorId == TLGzipObject.CONSTRUCTOR_ID)
            return deserializeMessage(unzipStream(stream));
        if (constructorId == TLBool.TRUE_CONSTRUCTOR_ID)
            return TLBool.TRUE;
        if (constructorId == TLBool.FALSE_CONSTRUCTOR_ID)
            return TLBool.FALSE;
        if (constructorId == TLVector.CONSTRUCTOR_ID) {
            /* Vector should be demobilized via the appropriate method, a vector was not expected,
             we must assume it's not any of vector<int>, vector<long>, vector<string> */
            TLVector<Object> vector = new TLVector<>();
            vector.deserializeBody(stream, this);
            return vector;
        }

        try {
            Class messageClass = registeredClasses.get(constructorId);
            if (messageClass != null) {
                @SuppressWarnings("unchecked")
                TLObject message = (TLObject) messageClass.getConstructor().newInstance();
                message.deserializeBody(stream, this);
                return message;
            } else {
                throw new DeserializationException("Unsupported constructor: #" + Integer.toHexString(constructorId));
            }
        } catch (DeserializationException e) {
            throw e;
        } catch (Exception e) {
            // Reflection exceptions
            throw new IOException("Unable to deserialize data");
        }
    }

    public TLVector deserializeVector(InputStream stream) throws IOException {
        return deserializeVector(stream, new TLVector<>());
    }

    public final TLIntVector deserializeIntVector(InputStream stream) throws IOException {
        return (TLIntVector) deserializeVector(stream, new TLIntVector());
    }

    public final TLLongVector deserializeLongVector(InputStream stream) throws IOException {
        return (TLLongVector) deserializeVector(stream, new TLLongVector());
    }

    public final TLStringVector deserializeStringVector(InputStream stream) throws IOException {
        return (TLStringVector) deserializeVector(stream, new TLStringVector());
    }

    private TLVector<?> deserializeVector(InputStream stream, TLVector<?> vector) throws IOException {
        int constructorId = StreamUtils.readInt(stream);
        if (constructorId == TLGzipObject.CONSTRUCTOR_ID)
            return deserializeVector(unzipStream(stream));

        if (constructorId == TLVector.CONSTRUCTOR_ID) {
            vector.deserializeBody(stream, this);
            return vector;
        }

        throw new InvalidConstructorIdException(constructorId, TLVector.CONSTRUCTOR_ID);
    }

    private InputStream unzipStream(InputStream stream) throws IOException {
        TLGzipObject obj = new TLGzipObject();
        obj.deserializeBody(stream, this);
        ByteArrayInputStream packedDataStream = new ByteArrayInputStream(obj.getPackedData());
        return new BufferedInputStream(new GZIPInputStream(packedDataStream));
    }
}
