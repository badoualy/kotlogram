package com.github.badoualy.telegram.tl;

import com.github.badoualy.telegram.tl.core.TLBoolFalse;
import com.github.badoualy.telegram.tl.core.TLBoolTrue;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLGzipObject;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
import com.github.badoualy.telegram.tl.core.TLVector;

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
 * If TL-Object contains static int field CLASS_ID, then it might be used for registration,
 * but it uses reflection so it might be slow in some cases. It recommended to manually pass CLASS_ID
 * to registerClass method.
 *
 * @author Korshakov Stepan me@ex3ndr.com
 */
public abstract class TLContext {

    private HashMap<Integer, Class> registeredClasses;

    public TLContext() {
        registeredClasses = new HashMap<Integer, Class>();
        init();
    }

    public TLContext(int size) {
        registeredClasses = new HashMap<Integer, Class>(size);
        init();
    }

    protected void init() {

    }

    public boolean isSupportedObject(TLObject object) {
        return isSupportedObject(object.getClassId());
    }

    public boolean isSupportedObject(int classId) {
        return registeredClasses.containsKey(classId);
    }

    public <T extends TLObject> void registerClass(Class<T> clazz) {
        try {
            int classId = clazz.getField("CLASS_ID").getInt(null);
            registeredClasses.put(classId, clazz);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public <T extends TLObject> void registerClass(int clazzId, Class<T> clazz) {
        registeredClasses.put(clazzId, clazz);
    }

    public TLObject deserializeMessage(byte[] data) throws IOException {
        return deserializeMessage(new ByteArrayInputStream(data));
    }

    public TLObject deserializeMessage(int clazzId, InputStream stream) throws IOException {
        if (clazzId == TLGzipObject.CLASS_ID) {
            TLGzipObject obj = new TLGzipObject();
            obj.deserializeBody(stream, this);
            BufferedInputStream gzipInputStream = new BufferedInputStream(
                    new GZIPInputStream(new ByteArrayInputStream(obj.getPackedData())));
            int innerClazzId = StreamUtils.readInt(gzipInputStream);
            return deserializeMessage(innerClazzId, gzipInputStream);
        }

        if (clazzId == TLBoolTrue.CLASS_ID) {
            return new TLBoolTrue();
        }

        if (clazzId == TLBoolFalse.CLASS_ID) {
            return new TLBoolFalse();
        }

        try {
            Class messageClass = registeredClasses.get(clazzId);
            if (messageClass != null) {
                @SuppressWarnings("unchecked")
                TLObject message = (TLObject) messageClass.getConstructor().newInstance();
                message.deserializeBody(stream, this);
                return message;
            } else {
                throw new DeserializeException("Unsupported class: #" + Integer.toHexString(clazzId));
            }
        } catch (DeserializeException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Unable to deserialize data");
        }
    }

    public TLObject deserializeMessage(InputStream stream) throws IOException {
        int clazzId = StreamUtils.readInt(stream);
        return deserializeMessage(clazzId, stream);
    }

    public TLVector deserializeVector(InputStream stream) throws IOException {
        int clazzId = StreamUtils.readInt(stream);
        if (clazzId == TLVector.CLASS_ID) {
            TLVector res = new TLVector();
            res.deserializeBody(stream, this);
            return res;
        } else if (clazzId == TLGzipObject.CLASS_ID) {
            TLGzipObject obj = new TLGzipObject();
            obj.deserializeBody(stream, this);
            BufferedInputStream gzipInputStream = new BufferedInputStream(
                    new GZIPInputStream(new ByteArrayInputStream(obj.getPackedData())));
            return deserializeVector(gzipInputStream);
        } else {
            throw new IOException("Unable to deserialize vector");
        }
    }

    public TLIntVector deserializeIntVector(InputStream stream) throws IOException {
        int clazzId = StreamUtils.readInt(stream);
        if (clazzId == TLVector.CLASS_ID) {
            TLIntVector res = new TLIntVector();
            res.deserializeBody(stream, this);
            return res;
        } else if (clazzId == TLGzipObject.CLASS_ID) {
            TLGzipObject obj = new TLGzipObject();
            obj.deserializeBody(stream, this);
            BufferedInputStream gzipInputStream = new BufferedInputStream(
                    new GZIPInputStream(new ByteArrayInputStream(obj.getPackedData())));
            return deserializeIntVector(gzipInputStream);
        } else {
            throw new IOException("Unable to deserialize vector");
        }
    }

    public TLLongVector deserializeLongVector(InputStream stream) throws IOException {
        int clazzId = StreamUtils.readInt(stream);
        if (clazzId == TLVector.CLASS_ID) {
            TLLongVector res = new TLLongVector();
            res.deserializeBody(stream, this);
            return res;
        } else if (clazzId == TLGzipObject.CLASS_ID) {
            TLGzipObject obj = new TLGzipObject();
            obj.deserializeBody(stream, this);
            BufferedInputStream gzipInputStream = new BufferedInputStream(
                    new GZIPInputStream(new ByteArrayInputStream(obj.getPackedData())));
            return deserializeLongVector(gzipInputStream);
        } else {
            throw new IOException("Unable to deserialize vector");
        }
    }

    public TLStringVector deserializeStringVector(InputStream stream) throws IOException {
        int clazzId = StreamUtils.readInt(stream);
        if (clazzId == TLVector.CLASS_ID) {
            TLStringVector res = new TLStringVector();
            res.deserializeBody(stream, this);
            return res;
        } else if (clazzId == TLGzipObject.CLASS_ID) {
            TLGzipObject obj = new TLGzipObject();
            obj.deserializeBody(stream, this);
            BufferedInputStream gzipInputStream = new BufferedInputStream(
                    new GZIPInputStream(new ByteArrayInputStream(obj.getPackedData())));
            return deserializeStringVector(gzipInputStream);
        } else {
            throw new IOException("Unable to deserialize vector");
        }
    }

    public TLBytes allocateBytes(int size) {
        return new TLBytes(new byte[size], 0, size);
    }
}
