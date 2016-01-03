
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


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
