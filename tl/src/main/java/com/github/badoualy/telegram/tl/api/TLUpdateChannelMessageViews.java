
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLUpdateChannelMessageViews extends TLAbsUpdate {
    public static final int CLASS_ID = 0x98a12b4b;

    public TLUpdateChannelMessageViews() {

    }


    public TLUpdateChannelMessageViews(        int _channelId,         int _id,         int _views) {
        this.channelId = _channelId;
        this.id = _id;
        this.views = _views;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int channelId;

    protected int id;

    protected int views;


    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int value) {
        this.channelId = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int value) {
        this.views = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.channelId, stream);
        writeInt(this.id, stream);
        writeInt(this.views, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channelId = readInt(stream);
        this.id = readInt(stream);
        this.views = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateChannelMessageViews#98a12b4b";
    }

}
