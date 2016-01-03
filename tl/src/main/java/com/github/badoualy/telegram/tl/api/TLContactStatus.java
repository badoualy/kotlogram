
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLContactStatus extends TLObject {

    public static final int CLASS_ID = 0xaa77b873;

    public TLContactStatus() {

    }


    public TLContactStatus(        int _userId,         int _expires) {
        this.userId = _userId;
        this.expires = _expires;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected int expires;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int value) {
        this.expires = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeInt(this.expires, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.expires = readInt(stream);
    }


    @Override
    public String toString() {
        return "contactStatus#aa77b873";
    }

}
