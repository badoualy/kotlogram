package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLInputMediaUploadedThumbDocument extends TLAbsInputMedia {
    public static final int CLASS_ID = 0xad613491;

    protected TLAbsInputFile file;

    protected TLAbsInputFile thumb;

    protected String mimeType;

    protected TLVector<TLAbsDocumentAttribute> attributes;

    protected String caption;

    public TLInputMediaUploadedThumbDocument() {
    }

    public TLInputMediaUploadedThumbDocument(TLAbsInputFile file, TLAbsInputFile thumb, String mimeType, TLVector<TLAbsDocumentAttribute> attributes, String caption) {
        this.file = file;
        this.thumb = thumb;
        this.mimeType = mimeType;
        this.attributes = attributes;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(file, stream);
        writeTLObject(thumb, stream);
        writeTLString(mimeType, stream);
        writeTLVector(attributes, stream);
        writeTLString(caption, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile) readTLObject(stream, context);
        thumb = (com.github.badoualy.telegram.tl.api.TLAbsInputFile) readTLObject(stream, context);
        mimeType = readTLString(stream);
        attributes = readTLVector(stream, context);
        caption = readTLString(stream);
    }

    @Override
    public String toString() {
        return "inputMediaUploadedThumbDocument#ad613491";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputFile file) {
        this.file = file;
    }

    public TLAbsInputFile getThumb() {
        return thumb;
    }

    public void setThumb(TLAbsInputFile thumb) {
        this.thumb = thumb;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public TLVector<TLAbsDocumentAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(TLVector<TLAbsDocumentAttribute> attributes) {
        this.attributes = attributes;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
