package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputReportReasonViolence extends TLAbsReportReason {
    public static final int CONSTRUCTOR_ID = 0x1e22c78d;

    public TLInputReportReasonViolence() {
    }

    @Override
    public String toString() {
        return "inputReportReasonViolence#1e22c78d";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
