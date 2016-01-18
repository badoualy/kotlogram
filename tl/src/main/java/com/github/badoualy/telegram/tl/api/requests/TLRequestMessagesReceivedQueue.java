
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLRequestMessagesReceivedQueue extends TLMethod<com.github.badoualy.telegram.tl.core.TLLongVector> {

    public static final int CLASS_ID = 0x55a5bb66;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesReceivedQueue(        int _maxQts) {
        this.maxQts = _maxQts;

    }



    public com.github.badoualy.telegram.tl.core.TLLongVector deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return readTLLongVector(stream, context);

    }
        


    protected int maxQts;


    public int getMaxQts() {
        return maxQts;
    }

    public void setMaxQts(int value) {
        this.maxQts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.maxQts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.maxQts = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.receivedQueue#55a5bb66";
    }

}
