
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestMessagesGetStickerSet extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLStickerSet> {

    public static final int CLASS_ID = 0x2619a90e;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetStickerSet(        com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet _stickerset) {
        this.stickerset = _stickerset;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLStickerSet deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLStickerSet) {
            return (com.github.badoualy.telegram.tl.api.messages.TLStickerSet)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLStickerSet, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet stickerset;


    public com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet value) {
        this.stickerset = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.stickerset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.stickerset = (com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messages.getStickerSet#2619a90e";
    }

}
