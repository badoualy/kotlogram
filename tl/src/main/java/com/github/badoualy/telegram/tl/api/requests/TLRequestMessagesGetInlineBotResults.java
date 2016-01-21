
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestMessagesGetInlineBotResults extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLBotResults> {

    public static final int CLASS_ID = 0x9324600d;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetInlineBotResults(        com.github.badoualy.telegram.tl.api.TLAbsInputUser _bot,         String _query,         String _offset) {
        this.bot = _bot;
        this.query = _query;
        this.offset = _offset;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLBotResults deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLBotResults) {
            return (com.github.badoualy.telegram.tl.api.messages.TLBotResults)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLBotResults, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputUser bot;

    protected String query;

    protected String offset;


    public com.github.badoualy.telegram.tl.api.TLAbsInputUser getBot() {
        return bot;
    }

    public void setBot(com.github.badoualy.telegram.tl.api.TLAbsInputUser value) {
        this.bot = value;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String value) {
        this.query = value;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String value) {
        this.offset = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.bot, stream);
        writeTLString(this.query, stream);
        writeTLString(this.offset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.bot = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
        this.query = readTLString(stream);
        this.offset = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messages.getInlineBotResults#9324600d";
    }

}
