
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLRequestAccountUpdateDeviceLocked extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x38df3532;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountUpdateDeviceLocked(        int _period) {
        this.period = _period;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int period;


    public int getPeriod() {
        return period;
    }

    public void setPeriod(int value) {
        this.period = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.period, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.period = readInt(stream);
    }



    @Override
    public String toString() {
        return "account.updateDeviceLocked#38df3532";
    }

}
