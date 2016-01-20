
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLDocumentAttributeAudio extends TLAbsDocumentAttribute {
    public static final int CLASS_ID = 0x51448e5;

    public TLDocumentAttributeAudio() {

    }


    public TLDocumentAttributeAudio(        int _duration) {
        this.duration = _duration;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int duration;


    public int getDuration() {
        return duration;
    }

    public void setDuration(int value) {
        this.duration = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.duration, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.duration = readInt(stream);
    }



    @Override
    public String toString() {
        return "documentAttributeAudio#51448e5";
    }

}
