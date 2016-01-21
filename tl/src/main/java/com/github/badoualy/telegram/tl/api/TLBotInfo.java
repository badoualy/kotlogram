
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLBotInfo extends TLAbsBotInfo {
    public static final int CLASS_ID = 0x9cf585d;

    public TLBotInfo() {

    }


    public TLBotInfo(        int _userId,         int _version,         String _shareText,         String _description,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLBotCommand> _commands) {
        this.userId = _userId;
        this.version = _version;
        this.shareText = _shareText;
        this.description = _description;
        this.commands = _commands;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected int version;

    protected String shareText;

    protected String description;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLBotCommand> commands;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }

    public String getShareText() {
        return shareText;
    }

    public void setShareText(String value) {
        this.shareText = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLBotCommand> getCommands() {
        return commands;
    }

    public void setCommands(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLBotCommand> value) {
        this.commands = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeInt(this.version, stream);
        writeTLString(this.shareText, stream);
        writeTLString(this.description, stream);
        writeTLVector(this.commands, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.version = readInt(stream);
        this.shareText = readTLString(stream);
        this.description = readTLString(stream);
        this.commands = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "botInfo#9cf585d";
    }

}
