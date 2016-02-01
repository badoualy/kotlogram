package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateUserPhoto extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x95313b0c;

    protected int userId;

    protected int date;

    protected TLAbsUserProfilePhoto photo;

    protected boolean previous;

    public TLUpdateUserPhoto() {
    }

    public TLUpdateUserPhoto(int userId, int date, TLAbsUserProfilePhoto photo, boolean previous) {
        this.userId = userId;
        this.date = date;
        this.photo = photo;
        this.previous = previous;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(userId, stream);
        writeInt(date, stream);
        writeTLObject(photo, stream);
        writeTLBool(previous, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readInt(stream);
        date = readInt(stream);
        photo = (com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto) readTLObject(stream, context);
        previous = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "updateUserPhoto#95313b0c";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsUserProfilePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsUserProfilePhoto photo) {
        this.photo = photo;
    }

    public boolean getPrevious() {
        return previous;
    }

    public void setPrevious(boolean previous) {
        this.previous = previous;
    }
}
