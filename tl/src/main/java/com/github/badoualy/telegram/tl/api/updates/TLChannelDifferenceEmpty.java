
package com.github.badoualy.telegram.tl.api.updates;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;



public class TLChannelDifferenceEmpty extends TLAbsChannelDifference {
    public static final int CLASS_ID = 0x3e11affb;

    public TLChannelDifferenceEmpty() {

    }


    public TLChannelDifferenceEmpty(        int _flags,         boolean _fina,         int _pts,         int _timeout) {
        this.flags = _flags;
        this.fina = _fina;
        this.pts = _pts;
        this.timeout = _timeout;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = fina ? (flags | 1) : (flags &~ 1);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.fina, stream);
        writeInt(this.pts, stream);
        if ((this.flags & 2) != 0)
            writeInt(this.timeout, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.fina = (this.flags & 1) != 0;
        this.pts = readInt(stream);
        if ((this.flags & 2) != 0)
            this.timeout = readInt(stream);
    }



    @Override
    public String toString() {
        return "updates.channelDifferenceEmpty#3e11affb";
    }

}
