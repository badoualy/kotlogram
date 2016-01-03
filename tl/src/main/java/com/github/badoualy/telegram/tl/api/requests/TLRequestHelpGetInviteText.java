
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestHelpGetInviteText extends TLMethod<com.github.badoualy.telegram.tl.api.help.TLInviteText> {

    public static final int CLASS_ID = 0xa4a95186;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestHelpGetInviteText(        String _langCode) {
        this.langCode = _langCode;

    }



    public com.github.badoualy.telegram.tl.api.help.TLInviteText deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.help.TLInviteText) {
            return (com.github.badoualy.telegram.tl.api.help.TLInviteText)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.help.TLInviteText, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String langCode;


    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String value) {
        this.langCode = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.langCode, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.langCode = readTLString(stream);
    }



    @Override
    public String toString() {
        return "help.getInviteText#a4a95186";
    }

}
