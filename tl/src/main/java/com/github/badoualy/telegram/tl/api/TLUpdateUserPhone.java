
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLUpdateUserPhone extends TLAbsUpdate {
    public static final int CLASS_ID = 0x12b9417b;

    public TLUpdateUserPhone() {

    }


    public TLUpdateUserPhone(        int _userId,         String _phone) {
        this.userId = _userId;
        this.phone = _phone;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected String phone;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeTLString(this.phone, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.phone = readTLString(stream);
    }



    @Override
    public String toString() {
        return "updateUserPhone#12b9417b";
    }

}
