package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLKeyboardButtonRow extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x77608b83;

    protected TLVector<TLAbsKeyboardButton> buttons;

    private final String _constructor = "keyboardButtonRow#77608b83";

    public TLKeyboardButtonRow() {
    }

    public TLKeyboardButtonRow(TLVector<TLAbsKeyboardButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(buttons, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        buttons = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += buttons.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLVector<TLAbsKeyboardButton> getButtons() {
        return buttons;
    }

    public void setButtons(TLVector<TLAbsKeyboardButton> buttons) {
        this.buttons = buttons;
    }
}
