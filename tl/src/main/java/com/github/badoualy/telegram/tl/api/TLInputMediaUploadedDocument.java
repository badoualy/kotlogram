package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMediaUploadedDocument extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x1d89306d;

    protected TLAbsInputFile file;

    protected String mimeType;

    protected TLVector<TLAbsDocumentAttribute> attributes;

    protected String caption;

    public TLInputMediaUploadedDocument() {
    }

    public TLInputMediaUploadedDocument(TLAbsInputFile file, String mimeType, TLVector<TLAbsDocumentAttribute> attributes, String caption) {
        this.file = file;
        this.mimeType = mimeType;
        this.attributes = attributes;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(file, stream);
        writeTLString(mimeType, stream);
        writeTLVector(attributes, stream);
        writeTLString(caption, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile) readTLObject(stream, context);
        mimeType = readTLString(stream);
        attributes = readTLVector(stream, context);
        caption = readTLString(stream);
    }

    @Override
    public String toString() {
        return "inputMediaUploadedDocument#1d89306d";
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
