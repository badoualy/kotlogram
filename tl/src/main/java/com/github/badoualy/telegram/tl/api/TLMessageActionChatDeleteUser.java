
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageActionChatDeleteUser extends TLAbsMessageAction {
    public static final int CLASS_ID = 0xb2ae9b0c;

    public TLMessageActionChatDeleteUser() {

    }


    public TLMessageActionChatDeleteUser(        int _userId) {
        this.userId = _userId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
    }



    @Override
    public String toString() {
        return "messageActionChatDeleteUser#b2ae9b0c";
    }

}
