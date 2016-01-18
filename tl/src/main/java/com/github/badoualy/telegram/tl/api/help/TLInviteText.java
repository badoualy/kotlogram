
package com.github.badoualy.telegram.tl.api.help;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLInviteText extends TLObject {

    public static final int CLASS_ID = 0x18cb9f78;

    public TLInviteText() {

    }


    public TLInviteText(        String _message) {
        this.message = _message;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.message, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = readTLString(stream);
    }


    @Override
    public String toString() {
        return "help.inviteText#18cb9f78";
    }

}
