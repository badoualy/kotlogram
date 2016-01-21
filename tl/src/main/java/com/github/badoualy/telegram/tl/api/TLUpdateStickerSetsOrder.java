
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLUpdateStickerSetsOrder extends TLAbsUpdate {
    public static final int CLASS_ID = 0xf0dfb451;

    public TLUpdateStickerSetsOrder() {

    }


    public TLUpdateStickerSetsOrder(        com.github.badoualy.telegram.tl.core.TLLongVector _order) {
        this.order = _order;

    }


    public int getClassId() {
        return CLASS_ID;
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
        return "updateStickerSetsOrder#f0dfb451";
    }

}
