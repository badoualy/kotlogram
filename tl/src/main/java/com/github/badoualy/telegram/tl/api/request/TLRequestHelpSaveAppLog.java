package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLInputAppEvent;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestHelpSaveAppLog extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0x6f02f748;

    protected TLVector<TLInputAppEvent> events;

    public TLRequestHelpSaveAppLog() {
    }

    public TLRequestHelpSaveAppLog(TLVector<TLInputAppEvent> events) {
        this.events = events;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(events, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        events = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "help.saveAppLog#6f02f748";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLInputAppEvent> getEvents() {
        return events;
    }

    public void setEvents(TLVector<TLInputAppEvent> events) {
        this.events = events;
    }
}
