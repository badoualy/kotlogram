package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLTopPeerCategoryCorrespondents extends TLAbsTopPeerCategory {

    public static final int CONSTRUCTOR_ID = 0x637b7ed;

    private final String _constructor = "topPeerCategoryCorrespondents#637b7ed";

    public TLTopPeerCategoryCorrespondents() {
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
