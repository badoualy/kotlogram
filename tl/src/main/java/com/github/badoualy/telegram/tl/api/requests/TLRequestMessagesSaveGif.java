
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


public class TLRequestMessagesSaveGif extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x327a30cb;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSaveGif(        com.github.badoualy.telegram.tl.api.TLAbsInputDocument _id,         boolean _unsave) {
        this.id = _id;
        this.unsave = _unsave;

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
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputDocument id;

    protected boolean unsave;


    public com.github.badoualy.telegram.tl.api.TLAbsInputDocument getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.api.TLAbsInputDocument value) {
        this.id = value;
    }

    public boolean getUnsave() {
        return unsave;
    }

    public void setUnsave(boolean value) {
        this.unsave = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
        writeTLBool(this.unsave, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (com.github.badoualy.telegram.tl.api.TLAbsInputDocument)readTLObject(stream, context);
        this.unsave = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "messages.saveGif#327a30cb";
    }

}
