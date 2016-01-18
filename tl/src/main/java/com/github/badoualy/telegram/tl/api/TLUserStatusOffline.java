
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLUserStatusOffline extends TLAbsUserStatus {
    public static final int CLASS_ID = 0x8c703f;

    public TLUserStatusOffline() {

    }


    public TLUserStatusOffline(        int _wasOnline) {
        this.wasOnline = _wasOnline;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int wasOnline;


    public int getWasOnline() {
        return wasOnline;
    }

    public void setWasOnline(int value) {
        this.wasOnline = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.wasOnline, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.wasOnline = readInt(stream);
    }



    @Override
    public String toString() {
        return "userStatusOffline#8c703f";
    }

}
