package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputReportReasonSpam extends TLAbsReportReason {
    public static final int CONSTRUCTOR_ID = 0x58dbcab8;

    public TLInputReportReasonSpam() {
    }

    @Override
    public String toString() {
        return "inputReportReasonSpam#58dbcab8";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputReportReasonSpam)) return false;
        if (object == this) return true;

        TLInputReportReasonSpam o = (TLInputReportReasonSpam) object;

        return true;
    }
}
