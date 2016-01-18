
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLRequestUpdatesGetDifference extends TLMethod<com.github.badoualy.telegram.tl.api.updates.TLAbsDifference> {

    public static final int CLASS_ID = 0xa041495;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestUpdatesGetDifference(        int _pts,         int _date,         int _qts) {
        this.pts = _pts;
        this.date = _date;
        this.qts = _qts;

    }



    public com.github.badoualy.telegram.tl.api.updates.TLAbsDifference deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.updates.TLAbsDifference) {
            return (com.github.badoualy.telegram.tl.api.updates.TLAbsDifference)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.updates.TLAbsDifference, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int pts;

    protected int date;

    protected int qts;


    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int value) {
        this.qts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.pts, stream);
        writeInt(this.date, stream);
        writeInt(this.qts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.pts = readInt(stream);
        this.date = readInt(stream);
        this.qts = readInt(stream);
    }



    @Override
    public String toString() {
        return "updates.getDifference#a041495";
    }

}
