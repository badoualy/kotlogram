
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateNewStickerSet extends TLAbsUpdate {
    public static final int CLASS_ID = 0x688a30aa;

    public TLUpdateNewStickerSet() {

    }


    public TLUpdateNewStickerSet(        com.github.badoualy.telegram.tl.api.messages.TLStickerSet _stickerset) {
        this.stickerset = _stickerset;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.messages.TLStickerSet stickerset;


    public com.github.badoualy.telegram.tl.api.messages.TLStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(com.github.badoualy.telegram.tl.api.messages.TLStickerSet value) {
        this.stickerset = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.stickerset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.stickerset = (com.github.badoualy.telegram.tl.api.messages.TLStickerSet)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updateNewStickerSet#688a30aa";
    }

}
