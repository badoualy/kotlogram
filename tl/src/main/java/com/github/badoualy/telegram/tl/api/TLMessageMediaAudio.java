
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageMediaAudio extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0xc6b68300;

    public TLMessageMediaAudio() {

    }


    public TLMessageMediaAudio(        com.github.badoualy.telegram.tl.api.TLAbsAudio _audio) {
        this.audio = _audio;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsAudio audio;


    public com.github.badoualy.telegram.tl.api.TLAbsAudio getAudio() {
        return audio;
    }

    public void setAudio(com.github.badoualy.telegram.tl.api.TLAbsAudio value) {
        this.audio = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.audio, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.audio = (com.github.badoualy.telegram.tl.api.TLAbsAudio)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messageMediaAudio#c6b68300";
    }

}
