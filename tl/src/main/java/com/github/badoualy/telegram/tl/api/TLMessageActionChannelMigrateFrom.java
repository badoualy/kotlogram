
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLMessageActionChannelMigrateFrom extends TLAbsMessageAction {
    public static final int CLASS_ID = 0xb055eaee;

    public TLMessageActionChannelMigrateFrom() {

    }


    public TLMessageActionChannelMigrateFrom(        String _title,         int _chatId) {
        this.title = _title;
        this.chatId = _chatId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String title;

    protected int chatId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.title, stream);
        writeInt(this.chatId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.title = readTLString(stream);
        this.chatId = readInt(stream);
    }



    @Override
    public String toString() {
        return "messageActionChannelMigrateFrom#b055eaee";
    }

}
