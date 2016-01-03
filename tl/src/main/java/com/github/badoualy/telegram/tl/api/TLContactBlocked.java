
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLContactBlocked extends TLObject {

    public static final int CLASS_ID = 0x561bc879;

    public TLContactBlocked() {

    }


    public TLContactBlocked(        int _userId,         int _date) {
        this.userId = _userId;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected int date;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.date = readInt(stream);
    }


    @Override
    public String toString() {
        return "contactBlocked#561bc879";
    }

}
