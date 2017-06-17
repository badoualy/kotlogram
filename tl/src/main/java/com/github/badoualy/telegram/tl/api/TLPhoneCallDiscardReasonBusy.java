package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPhoneCallDiscardReasonBusy extends TLAbsPhoneCallDiscardReason {

    public static final int CONSTRUCTOR_ID = 0xfaf7e8c9;

    private final String _constructor = "phoneCallDiscardReasonBusy#faf7e8c9";

    public TLPhoneCallDiscardReasonBusy() {
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
