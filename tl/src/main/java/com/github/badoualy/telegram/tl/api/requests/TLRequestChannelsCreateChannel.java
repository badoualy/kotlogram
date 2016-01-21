
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestChannelsCreateChannel extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUpdates> {

    public static final int CLASS_ID = 0xf4893d7f;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestChannelsCreateChannel(        int _flags,         boolean _broadcast,         boolean _megagroup,         String _title,         String _about) {
        this.flags = _flags;
        this.broadcast = _broadcast;
        this.megagroup = _megagroup;
        this.title = _title;
        this.about = _about;

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
        


    protected int flags;

    protected boolean broadcast;

    protected boolean megagroup;

    protected String title;

    protected String about;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean value) {
        this.broadcast = value;
    }

    public boolean getMegagroup() {
        return megagroup;
    }

    public void setMegagroup(boolean value) {
        this.megagroup = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String value) {
        this.about = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = broadcast ? (flags | 1) : (flags &~ 1);
        flags = megagroup ? (flags | 2) : (flags &~ 2);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.broadcast, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.megagroup, stream);
        writeTLString(this.title, stream);
        writeTLString(this.about, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.broadcast = (this.flags & 1) != 0;
        this.megagroup = (this.flags & 2) != 0;
        this.title = readTLString(stream);
        this.about = readTLString(stream);
    }



    @Override
    public String toString() {
        return "channels.createChannel#f4893d7f";
    }

}
