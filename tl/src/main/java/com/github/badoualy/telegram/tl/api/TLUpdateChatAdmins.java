package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateChatAdmins extends TLAbsUpdate {
    public static final int CLASS_ID = 0x6e947941;

    protected int chatId;

    protected boolean enabled;

    protected int version;

    public TLUpdateChatAdmins() {
    }

    public TLUpdateChatAdmins(int chatId, boolean enabled, int version) {
        this.chatId = chatId;
        this.enabled = enabled;
        this.version = version;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(chatId, stream);
        writeTLBool(enabled, stream);
        writeInt(version, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatId = readInt(stream);
        enabled = readTLBool(stream);
        version = readInt(stream);
    }

    @Override
    public String toString() {
        return "updateChatAdmins#6e947941";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
