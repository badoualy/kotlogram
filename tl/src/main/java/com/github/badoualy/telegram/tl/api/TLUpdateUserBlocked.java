
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
