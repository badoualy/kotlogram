
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputMediaUploadedAudio extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x4e498cab;

    public TLInputMediaUploadedAudio() {

    }


    public TLInputMediaUploadedAudio(        com.github.badoualy.telegram.tl.api.TLAbsInputFile _file,         int _duration,         String _mimeType) {
        this.file = _file;
        this.duration = _duration;
        this.mimeType = _mimeType;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputFile file;

    protected int duration;

    protected String mimeType;


    public com.github.badoualy.telegram.tl.api.TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(com.github.badoualy.telegram.tl.api.TLAbsInputFile value) {
        this.file = value;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int value) {
        this.duration = value;
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
        writeInt(this.duration, stream);
        writeTLString(this.mimeType, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile)readTLObject(stream, context);
        this.duration = readInt(stream);
        this.mimeType = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputMediaUploadedAudio#4e498cab";
    }

}
