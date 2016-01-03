
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSentEncryptedFile extends TLAbsSentEncryptedMessage {
    public static final int CLASS_ID = 0x9493ff32;

    public TLSentEncryptedFile() {

    }


    public TLSentEncryptedFile(        int _date,         com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile _file) {
        this.date = _date;
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

        writeInt(this.date, stream);
        writeTLObject(this.file, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.date = readInt(stream);
        this.file = (com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messages.sentEncryptedFile#9493ff32";
    }

}
