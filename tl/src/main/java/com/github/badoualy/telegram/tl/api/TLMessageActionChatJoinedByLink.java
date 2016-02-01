package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionChatJoinedByLink extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0xf89cf5e8;

    protected int inviterId;

    public TLMessageActionChatJoinedByLink() {
    }

    public TLMessageActionChatJoinedByLink(int inviterId) {
        this.inviterId = inviterId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(inviterId, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        inviterId = readInt(stream);
    }

    @Override
    public String toString() {
        return "messageActionChatJoinedByLink#f89cf5e8";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getInviterId() {
        return inviterId;
    }

    public void setInviterId(int inviterId) {
        this.inviterId = inviterId;
    }
}
