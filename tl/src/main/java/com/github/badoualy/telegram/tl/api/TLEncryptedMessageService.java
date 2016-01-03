
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLEncryptedMessageService extends TLAbsEncryptedMessage {
    public static final int CLASS_ID = 0x23734b06;

    public TLEncryptedMessageService() {

    }


    public TLEncryptedMessageService(        long _randomId,         int _chatId,         int _date,         TLBytes _bytes) {
        this.randomId = _randomId;
        this.chatId = _chatId;
        this.date = _date;
        this.bytes = _bytes;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.randomId, stream);
        writeInt(this.chatId, stream);
        writeInt(this.date, stream);
        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.randomId = readLong(stream);
        this.chatId = readInt(stream);
        this.date = readInt(stream);
        this.bytes = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "encryptedMessageService#23734b06";
    }

}
