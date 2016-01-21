
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLMessageActionChatJoinedByLink extends TLAbsMessageAction {
    public static final int CLASS_ID = 0xf89cf5e8;

    public TLMessageActionChatJoinedByLink() {

    }


    public TLMessageActionChatJoinedByLink(        int _inviterId) {
        this.inviterId = _inviterId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int inviterId;


    public int getInviterId() {
        return inviterId;
    }

    public void setInviterId(int value) {
        this.inviterId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.inviterId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.inviterId = readInt(stream);
    }



    @Override
    public String toString() {
        return "messageActionChatJoinedByLink#f89cf5e8";
    }

}
