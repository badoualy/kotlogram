package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionChatCreate extends TLAbsMessageAction {
    public static final int CLASS_ID = 0xa6638b9a;

    protected String title;

    protected TLVector<Integer> users;

    public TLMessageActionChatCreate() {
    }

    public TLMessageActionChatCreate(String title, TLVector<Integer> users) {
        this.title = title;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(title, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        title = readTLString(stream);
        users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messageActionChatCreate#a6638b9a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLVector<Integer> getUsers() {
        return users;
    }

    public void setUsers(TLVector<Integer> users) {
        this.users = users;
    }
}
