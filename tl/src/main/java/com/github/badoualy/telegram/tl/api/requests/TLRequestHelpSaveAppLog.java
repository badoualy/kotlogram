
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestHelpSaveAppLog extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x6f02f748;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestHelpSaveAppLog(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputAppEvent> _events) {
        this.events = _events;

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
        


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputAppEvent> events;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputAppEvent> getEvents() {
        return events;
    }

    public void setEvents(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputAppEvent> value) {
        this.events = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.events, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.events = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "help.saveAppLog#6f02f748";
    }

}
