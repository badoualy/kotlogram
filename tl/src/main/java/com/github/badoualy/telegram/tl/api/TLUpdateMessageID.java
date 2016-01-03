
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUpdateMessageID extends TLAbsUpdate {
    public static final int CLASS_ID = 0x4e90bfd6;

    public TLUpdateMessageID() {

    }


    public TLUpdateMessageID(        int _id,         long _randomId) {
        this.id = _id;
        this.randomId = _randomId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int id;

    protected long randomId;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeLong(this.randomId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.randomId = readLong(stream);
    }



    @Override
    public String toString() {
        return "updateMessageID#4e90bfd6";
    }

}
