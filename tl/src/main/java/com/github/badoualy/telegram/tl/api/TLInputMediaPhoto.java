package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMediaPhoto extends TLAbsInputMedia {
    public static final int CLASS_ID = 0xe9bfb4f3;

    protected TLAbsInputPhoto id;

    protected String caption;

    public TLInputMediaPhoto() {
    }

    public TLInputMediaPhoto(TLAbsInputPhoto id, String caption) {
        this.id = id;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(id, stream);
        writeTLString(caption, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = (com.github.badoualy.telegram.tl.api.TLAbsInputPhoto) readTLObject(stream, context);
        caption = readTLString(stream);
    }

    @Override
    public String toString() {
        return "inputMediaPhoto#e9bfb4f3";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputPhoto getId() {
        return id;
    }

    public void setId(TLAbsInputPhoto id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
