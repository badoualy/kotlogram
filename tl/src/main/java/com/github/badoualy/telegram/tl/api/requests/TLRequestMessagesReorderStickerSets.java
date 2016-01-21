
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLRequestMessagesReorderStickerSets extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x9fcfbc30;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesReorderStickerSets(        com.github.badoualy.telegram.tl.core.TLLongVector _order) {
        this.order = _order;

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
        


    protected com.github.badoualy.telegram.tl.core.TLLongVector order;


    public com.github.badoualy.telegram.tl.core.TLLongVector getOrder() {
        return order;
    }

    public void setOrder(com.github.badoualy.telegram.tl.core.TLLongVector value) {
        this.order = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.order, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.order = readTLLongVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.reorderStickerSets#9fcfbc30";
    }

}
