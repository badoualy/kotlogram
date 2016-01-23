package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaVideo extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0x5bcf1675;

    protected TLAbsVideo video;

    protected String caption;

    public TLMessageMediaVideo() {
    }

    public TLMessageMediaVideo(TLAbsVideo video, String caption) {
        this.video = video;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(video, stream);
        writeTLString(caption, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        video = (com.github.badoualy.telegram.tl.api.TLAbsVideo) readTLObject(stream, context);
        caption = readTLString(stream);
    }

    @Override
    public String toString() {
        return "messageMediaVideo#5bcf1675";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsVideo getVideo() {
        return video;
    }

    public void setVideo(TLAbsVideo video) {
        this.video = video;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
