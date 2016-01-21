
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestMessagesInstallStickerSet extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x7b30c3a6;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesInstallStickerSet(        com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet _stickerset,         boolean _disabled) {
        this.stickerset = _stickerset;
        this.disabled = _disabled;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet stickerset;

    protected boolean disabled;


    public com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet value) {
        this.stickerset = value;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean value) {
        this.disabled = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.stickerset, stream);
        writeTLBool(this.disabled, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.stickerset = (com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet)readTLObject(stream, context);
        this.disabled = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "messages.installStickerSet#7b30c3a6";
    }

}
