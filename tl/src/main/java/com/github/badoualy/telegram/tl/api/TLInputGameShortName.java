package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputGameShortName extends TLAbsInputGame {

    public static final int CONSTRUCTOR_ID = 0xc331e80a;

    protected TLAbsInputUser botId;

    protected String shortName;

    private final String _constructor = "inputGameShortName#c331e80a";

    public TLInputGameShortName() {
    }

    public TLInputGameShortName(TLAbsInputUser botId, String shortName) {
        this.botId = botId;
        this.shortName = shortName;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(botId, stream);
        writeString(shortName, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        botId = readTLObject(stream, context, TLAbsInputUser.class, -1);
        shortName = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += botId.computeSerializedSize();
        size += computeTLStringSerializedSize(shortName);
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsInputUser getBotId() {
        return botId;
    }

    public void setBotId(TLAbsInputUser botId) {
        this.botId = botId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
