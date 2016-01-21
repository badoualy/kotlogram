
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLDocumentAttributeSticker extends TLAbsDocumentAttribute {
    public static final int CLASS_ID = 0x3a556302;

    public TLDocumentAttributeSticker() {

    }


    public TLDocumentAttributeSticker(        String _alt,         com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet _stickerset) {
        this.alt = _alt;
        this.stickerset = _stickerset;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String alt;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet stickerset;


    public String getAlt() {
        return alt;
    }

    public void setAlt(String value) {
        this.alt = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet value) {
        this.stickerset = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.alt, stream);
        writeTLObject(this.stickerset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.alt = readTLString(stream);
        this.stickerset = (com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "documentAttributeSticker#3a556302";
    }

}
