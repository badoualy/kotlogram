
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestMessagesStartBot extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUpdates> {

    public static final int CLASS_ID = 0xe6df7378;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesStartBot(        com.github.badoualy.telegram.tl.api.TLAbsInputUser _bot,         com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         long _randomId,         String _startParam) {
        this.bot = _bot;
        this.peer = _peer;
        this.randomId = _randomId;
        this.startParam = _startParam;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsUpdates) {
            return (com.github.badoualy.telegram.tl.api.TLAbsUpdates)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsUpdates, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputUser bot;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;

    protected long randomId;

    protected String startParam;


    public com.github.badoualy.telegram.tl.api.TLAbsInputUser getBot() {
        return bot;
    }

    public void setBot(com.github.badoualy.telegram.tl.api.TLAbsInputUser value) {
        this.bot = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }

    public String getStartParam() {
        return startParam;
    }

    public void setStartParam(String value) {
        this.startParam = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.bot, stream);
        writeTLObject(this.peer, stream);
        writeLong(this.randomId, stream);
        writeTLString(this.startParam, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.bot = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.randomId = readLong(stream);
        this.startParam = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messages.startBot#e6df7378";
    }

}
