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
public class TLPhotoSizeEmpty extends TLAbsPhotoSize {
    public static final int CLASS_ID = 0xe17e23c;

    protected String type;

    public TLPhotoSizeEmpty() {
    }

    public TLPhotoSizeEmpty(String type) {
        this.type = type;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(type, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = readTLString(stream);
    }

    @Override
    public String toString() {
        return "photoSizeEmpty#e17e23c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
