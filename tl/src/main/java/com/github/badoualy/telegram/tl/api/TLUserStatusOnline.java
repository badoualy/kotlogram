
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
