package com.github.badoualy.telegram.tl.api.contacts;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLTopPeersNotModified extends TLAbsTopPeers {

    public static final int CONSTRUCTOR_ID = 0xde266ef5;

    private final String _constructor = "contacts.topPeersNotModified#de266ef5";

    public TLTopPeersNotModified() {
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
