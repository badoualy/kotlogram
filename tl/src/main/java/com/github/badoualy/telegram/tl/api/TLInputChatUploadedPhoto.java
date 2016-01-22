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
public class TLInputChatUploadedPhoto extends TLAbsInputChatPhoto {
    public static final int CLASS_ID = 0x94254732;

    protected TLAbsInputFile file;

    protected TLAbsInputPhotoCrop crop;

    public TLInputChatUploadedPhoto() {
    }

    public TLInputChatUploadedPhoto(TLAbsInputFile file, TLAbsInputPhotoCrop crop) {
        this.file = file;
        this.crop = crop;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(file, stream);
        writeTLObject(crop, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile) readTLObject(stream, context);
        crop = (com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "inputChatUploadedPhoto#94254732";
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

    public TLAbsInputPhotoCrop getCrop() {
        return crop;
    }

    public void setCrop(TLAbsInputPhotoCrop crop) {
        this.crop = crop;
    }
}
