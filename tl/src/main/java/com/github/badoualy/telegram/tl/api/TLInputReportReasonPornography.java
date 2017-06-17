package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputReportReasonPornography extends TLAbsReportReason {

    public static final int CONSTRUCTOR_ID = 0x2e59d922;

    private final String _constructor = "inputReportReasonPornography#2e59d922";

    public TLInputReportReasonPornography() {
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
