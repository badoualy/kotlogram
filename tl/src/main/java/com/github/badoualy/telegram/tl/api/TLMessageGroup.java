
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLMessageGroup extends TLObject {

    public static final int CLASS_ID = 0xe8346f53;

    public TLMessageGroup() {

    }


    public TLMessageGroup(        int _minId,         int _maxId,         int _count,         int _date) {
        this.minId = _minId;
        this.maxId = _maxId;
        this.count = _count;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int minId;

    protected int maxId;

    protected int count;

    protected int date;


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

    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.minId, stream);
        writeInt(this.maxId, stream);
        writeInt(this.count, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.minId = readInt(stream);
        this.maxId = readInt(stream);
        this.count = readInt(stream);
        this.date = readInt(stream);
    }


    @Override
    public String toString() {
        return "messageGroup#e8346f53";
    }

}
