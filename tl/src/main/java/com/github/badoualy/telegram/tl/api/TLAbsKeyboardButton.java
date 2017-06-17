package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLKeyboardButton}: keyboardButton#a2fa4880</li>
 * <li>{@link TLKeyboardButtonBuy}: keyboardButtonBuy#afd93fbb</li>
 * <li>{@link TLKeyboardButtonCallback}: keyboardButtonCallback#683a5e46</li>
 * <li>{@link TLKeyboardButtonGame}: keyboardButtonGame#50f41ccf</li>
 * <li>{@link TLKeyboardButtonRequestGeoLocation}: keyboardButtonRequestGeoLocation#fc796b3f</li>
 * <li>{@link TLKeyboardButtonRequestPhone}: keyboardButtonRequestPhone#b16a6c29</li>
 * <li>{@link TLKeyboardButtonSwitchInline}: keyboardButtonSwitchInline#568a748</li>
 * <li>{@link TLKeyboardButtonUrl}: keyboardButtonUrl#258aff05</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsKeyboardButton extends TLObject {

    protected String text;

    public TLAbsKeyboardButton() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
