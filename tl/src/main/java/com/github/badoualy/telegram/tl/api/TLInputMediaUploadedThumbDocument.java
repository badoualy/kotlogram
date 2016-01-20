
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLInputMediaUploadedThumbDocument extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x41481486;

    public TLInputMediaUploadedThumbDocument() {

    }


    public TLInputMediaUploadedThumbDocument(        com.github.badoualy.telegram.tl.api.TLAbsInputFile _file,         com.github.badoualy.telegram.tl.api.TLAbsInputFile _thumb,         String _mimeType,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocumentAttribute> _attributes) {
        this.file = _file;
        this.thumb = _thumb;
        this.mimeType = _mimeType;
        this.attributes = _attributes;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputFile file;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputFile thumb;

    protected String mimeType;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocumentAttribute> attributes;


    public com.github.badoualy.telegram.tl.api.TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(com.github.badoualy.telegram.tl.api.TLAbsInputFile value) {
        this.file = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputFile getThumb() {
        return thumb;
    }

    public void setThumb(com.github.badoualy.telegram.tl.api.TLAbsInputFile value) {
        this.thumb = value;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String value) {
        this.mimeType = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocumentAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocumentAttribute> value) {
        this.attributes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.file, stream);
        writeTLObject(this.thumb, stream);
        writeTLString(this.mimeType, stream);
        writeTLVector(this.attributes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile)readTLObject(stream, context);
        this.thumb = (com.github.badoualy.telegram.tl.api.TLAbsInputFile)readTLObject(stream, context);
        this.mimeType = readTLString(stream);
        this.attributes = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "inputMediaUploadedThumbDocument#41481486";
    }

}
