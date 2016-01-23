package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMediaUploadedAudio extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x4e498cab;

    protected TLAbsInputFile file;

    protected int duration;

    protected String mimeType;

    public TLInputMediaUploadedAudio() {
    }

    public TLInputMediaUploadedAudio(TLAbsInputFile file, int duration, String mimeType) {
        this.file = file;
        this.duration = duration;
        this.mimeType = mimeType;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(file, stream);
        writeInt(duration, stream);
        writeTLString(mimeType, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile) readTLObject(stream, context);
        duration = readInt(stream);
        mimeType = readTLString(stream);
    }

    @Override
    public String toString() {
        return "inputMediaUploadedAudio#4e498cab";
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
