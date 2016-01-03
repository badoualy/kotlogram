
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUpdateShort extends TLAbsUpdates {
    public static final int CLASS_ID = 0x78d4dec1;

    public TLUpdateShort() {

    }


    public TLUpdateShort(        com.github.badoualy.telegram.tl.api.TLAbsUpdate _update,         int _date) {
        this.update = _update;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsUpdate update;

    protected int date;


    public com.github.badoualy.telegram.tl.api.TLAbsUpdate getUpdate() {
        return update;
    }

    public void setUpdate(com.github.badoualy.telegram.tl.api.TLAbsUpdate value) {
        this.update = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.update, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.update = (com.github.badoualy.telegram.tl.api.TLAbsUpdate)readTLObject(stream, context);
        this.date = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateShort#78d4dec1";
    }

}
