
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesReceivedMessages extends TLMethod<com.github.badoualy.telegram.tl.core.TLIntVector> {

    public static final int CLASS_ID = 0x28abcb68;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesReceivedMessages(        int _maxId) {
        this.maxId = _maxId;

    }



    public com.github.badoualy.telegram.tl.core.TLIntVector deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return readTLIntVector(stream, context);

    }
        


    protected int maxId;


    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.maxId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.maxId = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.receivedMessages#28abcb68";
    }

}
