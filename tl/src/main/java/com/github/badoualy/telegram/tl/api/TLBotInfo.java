package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInfo extends TLAbsBotInfo {
    public static final int CONSTRUCTOR_ID = 0x9cf585d;

    protected int userId;

    protected int version;

    protected String shareText;

    protected String description;

    protected TLVector<TLBotCommand> commands;

    public TLBotInfo() {
    }

    public TLBotInfo(int userId, int version, String shareText, String description, TLVector<TLBotCommand> commands) {
        this.userId = userId;
        this.version = version;
        this.shareText = shareText;
        this.description = description;
        this.commands = commands;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(userId, stream);
        writeInt(version, stream);
        writeTLString(shareText, stream);
        writeTLString(description, stream);
        writeTLVector(commands, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readInt(stream);
        version = readInt(stream);
        shareText = readTLString(stream);
        description = readTLString(stream);
        commands = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "botInfo#9cf585d";
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getShareText() {
        return shareText;
    }

    public void setShareText(String shareText) {
        this.shareText = shareText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TLVector<TLBotCommand> getCommands() {
        return commands;
    }

    public void setCommands(TLVector<TLBotCommand> commands) {
        this.commands = commands;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLBotInfo getAsBotInfo() {
        return this;
    }
}
