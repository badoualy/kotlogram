package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputReportReasonSpam extends TLAbsReportReason {

    public static final int CONSTRUCTOR_ID = 0x58dbcab8;

    private final String _constructor = "inputReportReasonSpam#58dbcab8";

    public TLInputReportReasonSpam() {
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
