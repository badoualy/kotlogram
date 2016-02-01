package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAccountDaysTTL extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xb8d0afdf;

    protected int days;

    public TLAccountDaysTTL() {
    }

    public TLAccountDaysTTL(int days) {
        this.days = days;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(days, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        days = readInt(stream);
    }

    @Override
    public String toString() {
        return "accountDaysTTL#b8d0afdf";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
