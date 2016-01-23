package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageUploadVideoAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0xe9763aec;

    protected int progress;

    public TLSendMessageUploadVideoAction() {
    }

    public TLSendMessageUploadVideoAction(int progress) {
        this.progress = progress;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(progress, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        progress = readInt(stream);
    }

    @Override
    public String toString() {
        return "sendMessageUploadVideoAction#e9763aec";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
