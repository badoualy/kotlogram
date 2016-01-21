
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLDocumentAttributeAudio extends TLAbsDocumentAttribute {
    public static final int CLASS_ID = 0xded218e0;

    public TLDocumentAttributeAudio() {

    }


    public TLDocumentAttributeAudio(        int _duration,         String _title,         String _performer) {
        this.duration = _duration;
        this.title = _title;
        this.performer = _performer;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int duration;

    protected String title;

    protected String performer;


    public int getDuration() {
        return duration;
    }

    public void setDuration(int value) {
        this.duration = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String value) {
        this.performer = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.duration, stream);
        writeTLString(this.title, stream);
        writeTLString(this.performer, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.duration = readInt(stream);
        this.title = readTLString(stream);
        this.performer = readTLString(stream);
    }



    @Override
    public String toString() {
        return "documentAttributeAudio#ded218e0";
    }

}
