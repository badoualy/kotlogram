
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLUpdateEncryptedMessagesRead extends TLAbsUpdate {
    public static final int CLASS_ID = 0x38fe25b7;

    public TLUpdateEncryptedMessagesRead() {

    }


    public TLUpdateEncryptedMessagesRead(        int _chatId,         int _maxDate,         int _date) {
        this.chatId = _chatId;
        this.maxDate = _maxDate;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int chatId;

    protected int maxDate;

    protected int date;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public int getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(int value) {
        this.maxDate = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeInt(this.maxDate, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.maxDate = readInt(stream);
        this.date = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateEncryptedMessagesRead#38fe25b7";
    }

}
