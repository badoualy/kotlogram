
package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLSentChangePhoneCode extends TLObject {

    public static final int CLASS_ID = 0xa4f58c4c;

    public TLSentChangePhoneCode() {

    }


    public TLSentChangePhoneCode(        String _phoneCodeHash,         int _sendCallTimeout) {
        this.phoneCodeHash = _phoneCodeHash;
        this.sendCallTimeout = _sendCallTimeout;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String phoneCodeHash;

    protected int sendCallTimeout;


    public String getPhoneCodeHash() {
        return phoneCodeHash;
    }

    public void setPhoneCodeHash(String value) {
        this.phoneCodeHash = value;
    }

    public int getSendCallTimeout() {
        return sendCallTimeout;
    }

    public void setSendCallTimeout(int value) {
        this.sendCallTimeout = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.phoneCodeHash, stream);
        writeInt(this.sendCallTimeout, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneCodeHash = readTLString(stream);
        this.sendCallTimeout = readInt(stream);
    }


    @Override
    public String toString() {
        return "account.sentChangePhoneCode#a4f58c4c";
    }

}
