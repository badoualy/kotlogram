
package com.github.badoualy.telegram.tl.api.account;


import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLNoPassword extends TLAbsPassword {
    public static final int CLASS_ID = 0x96dabc18;

    public TLNoPassword() {

    }


    public TLNoPassword(        TLBytes _newSalt,         String _emailUnconfirmedPattern) {
        this.newSalt = _newSalt;
        this.emailUnconfirmedPattern = _emailUnconfirmedPattern;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBytes(this.newSalt, stream);
        writeTLString(this.emailUnconfirmedPattern, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.newSalt = readTLBytes(stream, context);
        this.emailUnconfirmedPattern = readTLString(stream);
    }



    @Override
    public String toString() {
        return "account.noPassword#96dabc18";
    }

}
