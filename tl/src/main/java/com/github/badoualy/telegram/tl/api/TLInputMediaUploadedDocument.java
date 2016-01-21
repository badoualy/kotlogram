
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



public class TLInputMediaUploadedDocument extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x1d89306d;

    public TLInputMediaUploadedDocument() {

    }


    public TLInputMediaUploadedDocument(        com.github.badoualy.telegram.tl.api.TLAbsInputFile _file,         String _mimeType,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocumentAttribute> _attributes,         String _caption) {
        this.file = _file;
        this.mimeType = _mimeType;
        this.attributes = _attributes;
        this.caption = _caption;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputFile file;

    protected String mimeType;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocumentAttribute> attributes;

    protected String caption;


    public com.github.badoualy.telegram.tl.api.TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(com.github.badoualy.telegram.tl.api.TLAbsInputFile value) {
        this.file = value;
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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String value) {
        this.caption = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.file, stream);
        writeTLString(this.mimeType, stream);
        writeTLVector(this.attributes, stream);
        writeTLString(this.caption, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile)readTLObject(stream, context);
        this.mimeType = readTLString(stream);
        this.attributes = readTLVector(stream, context);
        this.caption = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputMediaUploadedDocument#1d89306d";
    }

}
