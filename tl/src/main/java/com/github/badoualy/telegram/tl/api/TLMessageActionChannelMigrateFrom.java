package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionChannelMigrateFrom extends TLAbsMessageAction {
    public static final int CLASS_ID = 0xb055eaee;

    protected String title;

    protected int chatId;

    public TLMessageActionChannelMigrateFrom() {
    }

    public TLMessageActionChannelMigrateFrom(String title, int chatId) {
        this.title = title;
        this.chatId = chatId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(title, stream);
        writeInt(chatId, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        title = readTLString(stream);
        chatId = readInt(stream);
    }

    @Override
    public String toString() {
        return "messageActionChannelMigrateFrom#b055eaee";
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

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }
}
