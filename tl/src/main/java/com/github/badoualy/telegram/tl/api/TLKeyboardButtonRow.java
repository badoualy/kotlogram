
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLKeyboardButtonRow extends TLObject {

    public static final int CLASS_ID = 0x77608b83;

    public TLKeyboardButtonRow() {

    }


    public TLKeyboardButtonRow(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLKeyboardButton> _buttons) {
        this.buttons = _buttons;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLKeyboardButton> buttons;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLKeyboardButton> getButtons() {
        return buttons;
    }

    public void setButtons(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLKeyboardButton> value) {
        this.buttons = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.buttons, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.buttons = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "keyboardButtonRow#77608b83";
    }

}
