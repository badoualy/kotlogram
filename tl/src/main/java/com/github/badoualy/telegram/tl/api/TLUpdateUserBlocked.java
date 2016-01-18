
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;



public class TLUpdateUserBlocked extends TLAbsUpdate {
    public static final int CLASS_ID = 0x80ece81a;

    public TLUpdateUserBlocked() {

    }


    public TLUpdateUserBlocked(        int _userId,         boolean _blocked) {
        this.userId = _userId;
        this.blocked = _blocked;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected boolean blocked;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean value) {
        this.blocked = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeTLBool(this.blocked, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.blocked = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "updateUserBlocked#80ece81a";
    }

}
