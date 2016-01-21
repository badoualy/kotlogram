
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLBotInlineMessageMediaAuto extends TLAbsBotInlineMessage {
    public static final int CLASS_ID = 0xfc56e87d;

    public TLBotInlineMessageMediaAuto() {

    }


    public TLBotInlineMessageMediaAuto(        String _caption) {
        this.caption = _caption;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String caption;


    public String getCaption() {
        return caption;
    }

    public void setCaption(String value) {
        this.caption = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.caption, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.caption = readTLString(stream);
    }



    @Override
    public String toString() {
        return "botInlineMessageMediaAuto#fc56e87d";
    }

}
