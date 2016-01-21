
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLKeyboardButton extends TLObject {

    public static final int CLASS_ID = 0xa2fa4880;

    public TLKeyboardButton() {

    }


    public TLKeyboardButton(        String _text) {
        this.text = _text;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String text;


    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.text, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.text = readTLString(stream);
    }


    @Override
    public String toString() {
        return "keyboardButton#a2fa4880";
    }

}
