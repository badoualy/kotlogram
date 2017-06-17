package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyKeyChatInvite extends TLAbsPrivacyKey {

    public static final int CONSTRUCTOR_ID = 0x500e6dfa;

    private final String _constructor = "privacyKeyChatInvite#500e6dfa";

    public TLPrivacyKeyChatInvite() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
