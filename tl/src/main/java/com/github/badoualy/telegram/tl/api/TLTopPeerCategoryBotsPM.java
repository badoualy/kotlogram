package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLTopPeerCategoryBotsPM extends TLAbsTopPeerCategory {

    public static final int CONSTRUCTOR_ID = 0xab661b5b;

    private final String _constructor = "topPeerCategoryBotsPM#ab661b5b";

    public TLTopPeerCategoryBotsPM() {
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
