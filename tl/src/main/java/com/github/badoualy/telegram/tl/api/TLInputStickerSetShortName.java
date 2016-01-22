package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputStickerSetShortName extends TLAbsInputStickerSet {
    public static final int CLASS_ID = 0x861cc8a0;

    protected String shortName;

    public TLInputStickerSetShortName() {
    }

    public TLInputStickerSetShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(shortName, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        shortName = readTLString(stream);
    }

    @Override
    public String toString() {
        return "inputStickerSetShortName#861cc8a0";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
