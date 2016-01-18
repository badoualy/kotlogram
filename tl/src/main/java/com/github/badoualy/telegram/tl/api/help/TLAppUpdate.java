
package com.github.badoualy.telegram.tl.api.help;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLAppUpdate extends TLAbsAppUpdate {
    public static final int CLASS_ID = 0x8987f311;

    public TLAppUpdate() {

    }


    public TLAppUpdate(        int _id,         boolean _critical,         String _url,         String _text) {
        this.id = _id;
        this.critical = _critical;
        this.url = _url;
        this.text = _text;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int id;

    protected boolean critical;

    protected String url;

    protected String text;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public boolean getCritical() {
        return critical;
    }

    public void setCritical(boolean value) {
        this.critical = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLBool(this.critical, stream);
        writeTLString(this.url, stream);
        writeTLString(this.text, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.critical = readTLBool(stream);
        this.url = readTLString(stream);
        this.text = readTLString(stream);
    }



    @Override
    public String toString() {
        return "help.appUpdate#8987f311";
    }

}
