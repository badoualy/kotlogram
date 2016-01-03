
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesDeleteMessages extends TLMethod<com.github.badoualy.telegram.tl.core.TLIntVector> {

    public static final int CLASS_ID = 0x14f2dd0a;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesDeleteMessages(        com.github.badoualy.telegram.tl.core.TLIntVector _id) {
        this.id = _id;

    }



    public com.github.badoualy.telegram.tl.core.TLIntVector deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return readTLIntVector(stream, context);

    }
        


    protected com.github.badoualy.telegram.tl.core.TLIntVector id;


    public com.github.badoualy.telegram.tl.core.TLIntVector getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.core.TLIntVector value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readTLIntVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.deleteMessages#14f2dd0a";
    }

}
