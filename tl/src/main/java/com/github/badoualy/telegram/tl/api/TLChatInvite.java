
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLChatInvite extends TLAbsChatInvite {
    public static final int CLASS_ID = 0x93e99b60;

    public TLChatInvite() {

    }


    public TLChatInvite(        int _flags,         boolean _channel,         boolean _broadcast,         boolean _publi,         boolean _megagroup,         String _title) {
        this.flags = _flags;
        this.channel = _channel;
        this.broadcast = _broadcast;
        this.publi = _publi;
        this.megagroup = _megagroup;
        this.title = _title;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean channel;

    protected boolean broadcast;

    protected boolean publi;

    protected boolean megagroup;

    protected String title;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getChannel() {
        return channel;
    }

    public void setChannel(boolean value) {
        this.channel = value;
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean value) {
        this.broadcast = value;
    }

    public boolean getPubli() {
        return publi;
    }

    public void setPubli(boolean value) {
        this.publi = value;
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


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = channel ? (flags | 1) : (flags &~ 1);
        flags = broadcast ? (flags | 2) : (flags &~ 2);
        flags = publi ? (flags | 4) : (flags &~ 4);
        flags = megagroup ? (flags | 8) : (flags &~ 8);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.channel, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.broadcast, stream);
        if ((this.flags & 4) != 0)
            writeTLBool(this.publi, stream);
        if ((this.flags & 8) != 0)
            writeTLBool(this.megagroup, stream);
        writeTLString(this.title, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.channel = (this.flags & 1) != 0;
        this.broadcast = (this.flags & 2) != 0;
        this.publi = (this.flags & 4) != 0;
        this.megagroup = (this.flags & 8) != 0;
        this.title = readTLString(stream);
    }



    @Override
    public String toString() {
        return "chatInvite#93e99b60";
    }

}
