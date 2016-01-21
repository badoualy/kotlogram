
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLMessageRange extends TLObject {

    public static final int CLASS_ID = 0xae30253;

    public TLMessageRange() {

    }


    public TLMessageRange(        int _minId,         int _maxId) {
        this.minId = _minId;
        this.maxId = _maxId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int minId;

    protected int maxId;


    public int getMinId() {
        return minId;
    }

    public void setMinId(int value) {
        this.minId = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.minId, stream);
        writeInt(this.maxId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.minId = readInt(stream);
        this.maxId = readInt(stream);
    }


    @Override
    public String toString() {
        return "messageRange#ae30253";
    }

}
