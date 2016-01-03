
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageMediaVideo extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0xa2d24290;

    public TLMessageMediaVideo() {

    }


    public TLMessageMediaVideo(        com.github.badoualy.telegram.tl.api.TLAbsVideo _video) {
        this.video = _video;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsVideo video;


    public com.github.badoualy.telegram.tl.api.TLAbsVideo getVideo() {
        return video;
    }

    public void setVideo(com.github.badoualy.telegram.tl.api.TLAbsVideo value) {
        this.video = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.video, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.video = (com.github.badoualy.telegram.tl.api.TLAbsVideo)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messageMediaVideo#a2d24290";
    }

}
