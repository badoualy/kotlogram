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
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

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
        writeString(shareText, stream);
        writeString(description, stream);
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
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(shareText);
        size += computeTLStringSerializedSize(description);
        size += commands.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "botInfo#9cf585d";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLBotInfo)) return false;
        if (object == this) return true;

        TLBotInfo o = (TLBotInfo) object;

        return userId == o.userId
                && version == o.version
                && (shareText == o.shareText || (shareText != null && o.shareText != null && shareText.equals(o.shareText)))
                && (description == o.description || (description != null && o.description != null && description.equals(o.description)))
                && (commands == o.commands || (commands != null && o.commands != null && commands.equals(o.commands)));
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
