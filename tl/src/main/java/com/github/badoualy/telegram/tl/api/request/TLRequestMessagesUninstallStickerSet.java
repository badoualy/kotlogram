package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesUninstallStickerSet extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0xf96e55de;

    protected TLAbsInputStickerSet stickerset;

    public TLRequestMessagesUninstallStickerSet() {
    }

    public TLRequestMessagesUninstallStickerSet(TLAbsInputStickerSet stickerset) {
        this.stickerset = stickerset;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(stickerset, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        stickerset = (com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "messages.uninstallStickerSet#f96e55de";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(TLAbsInputStickerSet stickerset) {
        this.stickerset = stickerset;
    }
}
