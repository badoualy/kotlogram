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
public class TLInputMediaUploadedThumbVideo extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x7780ddf9;

    protected TLAbsInputFile file;

    protected TLAbsInputFile thumb;

    protected int duration;

    protected int w;

    protected int h;

    protected String mimeType;

    protected String caption;

    public TLInputMediaUploadedThumbVideo() {
    }

    public TLInputMediaUploadedThumbVideo(TLAbsInputFile file, TLAbsInputFile thumb, int duration, int w, int h, String mimeType, String caption) {
        this.file = file;
        this.thumb = thumb;
        this.duration = duration;
        this.w = w;
        this.h = h;
        this.mimeType = mimeType;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(file, stream);
        writeTLObject(thumb, stream);
        writeInt(duration, stream);
        writeInt(w, stream);
        writeInt(h, stream);
        writeTLString(mimeType, stream);
        writeTLString(caption, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile) readTLObject(stream, context);
        thumb = (com.github.badoualy.telegram.tl.api.TLAbsInputFile) readTLObject(stream, context);
        duration = readInt(stream);
        w = readInt(stream);
        h = readInt(stream);
        mimeType = readTLString(stream);
        caption = readTLString(stream);
    }

    @Override
    public String toString() {
        return "inputMediaUploadedThumbVideo#7780ddf9";
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
