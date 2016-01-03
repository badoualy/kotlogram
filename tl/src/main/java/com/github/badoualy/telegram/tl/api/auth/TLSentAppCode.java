
package com.github.badoualy.telegram.tl.api.auth;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSentAppCode extends TLAbsSentCode {
    public static final int CLASS_ID = 0xe325edcf;

    public TLSentAppCode() {

    }


    public TLSentAppCode(        boolean _phoneRegistered,         String _phoneCodeHash,         int _sendCallTimeout,         boolean _isPassword) {
        this.phoneRegistered = _phoneRegistered;
        this.phoneCodeHash = _phoneCodeHash;
        this.sendCallTimeout = _sendCallTimeout;
        this.isPassword = _isPassword;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBool(this.phoneRegistered, stream);
        writeTLString(this.phoneCodeHash, stream);
        writeInt(this.sendCallTimeout, stream);
        writeTLBool(this.isPassword, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneRegistered = readTLBool(stream);
        this.phoneCodeHash = readTLString(stream);
        this.sendCallTimeout = readInt(stream);
        this.isPassword = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "auth.sentAppCode#e325edcf";
    }

}
