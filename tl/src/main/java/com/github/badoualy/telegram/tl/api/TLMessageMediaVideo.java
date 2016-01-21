
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLMessageMediaVideo extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0x5bcf1675;

    public TLMessageMediaVideo() {

    }


    public TLMessageMediaVideo(        com.github.badoualy.telegram.tl.api.TLAbsVideo _video,         String _caption) {
        this.video = _video;
        this.caption = _caption;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsVideo video;

    protected String caption;


    public com.github.badoualy.telegram.tl.api.TLAbsVideo getVideo() {
        return video;
    }

    public void setVideo(com.github.badoualy.telegram.tl.api.TLAbsVideo value) {
        this.video = value;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String value) {
        this.caption = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.video, stream);
        writeTLString(this.caption, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.video = (com.github.badoualy.telegram.tl.api.TLAbsVideo)readTLObject(stream, context);
        this.caption = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messageMediaVideo#5bcf1675";
    }

}
