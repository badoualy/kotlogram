package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLKeyboardButtonRow extends TLObject {
    public static final int CLASS_ID = 0x77608b83;

    protected TLVector<TLKeyboardButton> buttons;

    public TLKeyboardButtonRow() {
    }

    public TLKeyboardButtonRow(TLVector<TLKeyboardButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(buttons, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        buttons = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "keyboardButtonRow#77608b83";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLKeyboardButton> getButtons() {
        return buttons;
    }

    public void setButtons(TLVector<TLKeyboardButton> buttons) {
        this.buttons = buttons;
    }
}
