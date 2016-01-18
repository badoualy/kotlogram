
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLUserStatusOnline extends TLAbsUserStatus {
    public static final int CLASS_ID = 0xedb93949;

    public TLUserStatusOnline() {

    }


    public TLUserStatusOnline(        int _expires) {
        this.expires = _expires;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int expires;


    public int getExpires() {
        return expires;
    }

    public void setExpires(int value) {
        this.expires = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.expires, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.expires = readInt(stream);
    }



    @Override
    public String toString() {
        return "userStatusOnline#edb93949";
    }

}
