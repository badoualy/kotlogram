package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPhoneCallDiscardReasonMissed extends TLAbsPhoneCallDiscardReason {

    public static final int CONSTRUCTOR_ID = 0x85e42301;

    private final String _constructor = "phoneCallDiscardReasonMissed#85e42301";

    public TLPhoneCallDiscardReasonMissed() {
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
