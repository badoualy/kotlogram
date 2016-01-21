
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLInputStickerSetShortName extends TLAbsInputStickerSet {
    public static final int CLASS_ID = 0x861cc8a0;

    public TLInputStickerSetShortName() {

    }


    public TLInputStickerSetShortName(        String _shortName) {
        this.shortName = _shortName;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String shortName;


    public String getShortName() {
        return shortName;
    }

    public void setShortName(String value) {
        this.shortName = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.shortName, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.shortName = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputStickerSetShortName#861cc8a0";
    }

}
