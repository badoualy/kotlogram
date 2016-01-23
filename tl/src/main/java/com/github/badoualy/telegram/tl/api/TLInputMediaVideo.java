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
public class TLInputMediaVideo extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x936a4ebd;

    protected TLAbsInputVideo id;

    protected String caption;

    public TLInputMediaVideo() {
    }

    public TLInputMediaVideo(TLAbsInputVideo id, String caption) {
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
        id = (com.github.badoualy.telegram.tl.api.TLAbsInputVideo) readTLObject(stream, context);
        caption = readTLString(stream);
    }

    @Override
    public String toString() {
        return "inputMediaVideo#936a4ebd";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputVideo getId() {
        return id;
    }

    public void setId(TLAbsInputVideo id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
