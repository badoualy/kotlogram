
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLAudioEmpty extends TLAbsAudio {
    public static final int CLASS_ID = 0x586988d8;

    public TLAudioEmpty() {

    }


    public TLAudioEmpty(        long _id) {
        this.id = _id;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
    }



    @Override
    public String toString() {
        return "audioEmpty#586988d8";
    }

}
