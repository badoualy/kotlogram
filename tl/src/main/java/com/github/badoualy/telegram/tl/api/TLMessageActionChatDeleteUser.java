
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



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
