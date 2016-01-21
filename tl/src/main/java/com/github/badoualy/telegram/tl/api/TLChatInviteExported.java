
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLChatInviteExported extends TLAbsExportedChatInvite {
    public static final int CLASS_ID = 0xfc2e05bc;

    public TLChatInviteExported() {

    }


    public TLChatInviteExported(        String _link) {
        this.link = _link;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String link;


    public String getLink() {
        return link;
    }

    public void setLink(String value) {
        this.link = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.link, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.link = readTLString(stream);
    }



    @Override
    public String toString() {
        return "chatInviteExported#fc2e05bc";
    }

}
