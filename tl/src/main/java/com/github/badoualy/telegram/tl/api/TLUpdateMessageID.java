
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;



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
