package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateChannelWebPage extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x40771900;

    protected int channelId;

    protected TLAbsWebPage webpage;

    protected int pts;

    protected int ptsCount;

    private final String _constructor = "updateChannelWebPage#40771900";

    public TLUpdateChannelWebPage() {
    }

    public TLUpdateChannelWebPage(int channelId, TLAbsWebPage webpage, int pts, int ptsCount) {
        this.channelId = channelId;
        this.webpage = webpage;
        this.pts = pts;
        this.ptsCount = ptsCount;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(channelId, stream);
        writeTLObject(webpage, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channelId = readInt(stream);
        webpage = readTLObject(stream, context, TLAbsWebPage.class, -1);
        pts = readInt(stream);
        ptsCount = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += webpage.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public TLAbsWebPage getWebpage() {
        return webpage;
    }

    public void setWebpage(TLAbsWebPage webpage) {
        this.webpage = webpage;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int ptsCount) {
        this.ptsCount = ptsCount;
    }
}
