
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLSentMessage extends TLAbsSentMessage {
    public static final int CLASS_ID = 0xd1f4d35c;

    public TLSentMessage() {

    }


    public TLSentMessage(        int _id,         int _date,         int _pts,         int _seq) {
        this.id = _id;
        this.date = _date;
        this.pts = _pts;
        this.seq = _seq;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeInt(this.date, stream);
        writeInt(this.pts, stream);
        writeInt(this.seq, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.date = readInt(stream);
        this.pts = readInt(stream);
        this.seq = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.sentMessage#d1f4d35c";
    }

}
