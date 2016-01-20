
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLAccountDaysTTL extends TLObject {

    public static final int CLASS_ID = 0xb8d0afdf;

    public TLAccountDaysTTL() {

    }


    public TLAccountDaysTTL(        int _days) {
        this.days = _days;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int days;


    public int getDays() {
        return days;
    }

    public void setDays(int value) {
        this.days = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.days, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.days = readInt(stream);
    }


    @Override
    public String toString() {
        return "accountDaysTTL#b8d0afdf";
    }

}
