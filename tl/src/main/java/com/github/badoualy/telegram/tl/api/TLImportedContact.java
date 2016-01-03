
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLImportedContact extends TLObject {

    public static final int CLASS_ID = 0xd0028438;

    public TLImportedContact() {

    }


    public TLImportedContact(        int _userId,         long _clientId) {
        this.userId = _userId;
        this.clientId = _clientId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected long clientId;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long value) {
        this.clientId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeLong(this.clientId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.clientId = readLong(stream);
    }


    @Override
    public String toString() {
        return "importedContact#d0028438";
    }

}
