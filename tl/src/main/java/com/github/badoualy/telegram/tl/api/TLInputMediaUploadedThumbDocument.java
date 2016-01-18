
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLInputMediaUploadedThumbDocument extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x3e46de5d;

    public TLInputMediaUploadedThumbDocument() {

    }


    public TLInputMediaUploadedThumbDocument(        com.github.badoualy.telegram.tl.api.TLAbsInputFile _file,         com.github.badoualy.telegram.tl.api.TLAbsInputFile _thumb,         String _fileName,         String _mimeType) {
        this.file = _file;
        this.thumb = _thumb;
        this.fileName = _fileName;
        this.mimeType = _mimeType;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputFile file;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputFile thumb;

    protected String fileName;

    protected String mimeType;


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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String value) {
        this.fileName = value;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String value) {
        this.mimeType = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.file, stream);
        writeTLObject(this.thumb, stream);
        writeTLString(this.fileName, stream);
        writeTLString(this.mimeType, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile)readTLObject(stream, context);
        this.thumb = (com.github.badoualy.telegram.tl.api.TLAbsInputFile)readTLObject(stream, context);
        this.fileName = readTLString(stream);
        this.mimeType = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputMediaUploadedThumbDocument#3e46de5d";
    }

}
