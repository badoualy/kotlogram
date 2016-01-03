package com.github.badoualy.telegram.tl.core;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Basic object for RPC methods. It contains special methods for deserializing result of RPC method call.
 *
 * @param <T> return type of method
 * @author Korshakov Stepan <me@ex3ndr.com>
 */
public abstract class TLMethod<T extends TLObject> extends TLObject {
    public T deserializeResponse(byte[] data, TLContext context) throws IOException {
        return deserializeResponse(new ByteArrayInputStream(data), context);
    }

    public abstract T deserializeResponse(InputStream stream, TLContext context) throws IOException;
}
