
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLEncryptedMessage extends TLAbsEncryptedMessage {
    public static final int CLASS_ID = 0xed18c118;

    public TLEncryptedMessage() {

    }


    public TLEncryptedMessage(        long _randomId,         int _chatId,         int _date,         TLBytes _bytes,         com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile _file) {
        this.randomId = _randomId;
        this.chatId = _chatId;
        this.date = _date;
        this.bytes = _bytes;
        this.file = _file;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile file;


    public com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile getFile() {
        return file;
    }

    public void setFile(com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile value) {
        this.file = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.randomId, stream);
        writeInt(this.chatId, stream);
        writeInt(this.date, stream);
        writeTLBytes(this.bytes, stream);
        writeTLObject(this.file, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.randomId = readLong(stream);
        this.chatId = readInt(stream);
        this.date = readInt(stream);
        this.bytes = readTLBytes(stream, context);
        this.file = (com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "encryptedMessage#ed18c118";
    }

}
