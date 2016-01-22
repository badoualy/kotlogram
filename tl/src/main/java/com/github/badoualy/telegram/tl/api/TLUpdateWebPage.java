package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateWebPage extends TLAbsUpdate {
    public static final int CLASS_ID = 0x7f891213;

    protected TLAbsWebPage webpage;

    protected int pts;

    protected int ptsCount;

    public TLUpdateWebPage() {
    }

    public TLUpdateWebPage(TLAbsWebPage webpage, int pts, int ptsCount) {
        this.webpage = webpage;
        this.pts = pts;
        this.ptsCount = ptsCount;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(webpage, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        webpage = (com.github.badoualy.telegram.tl.api.TLAbsWebPage) readTLObject(stream, context);
        pts = readInt(stream);
        ptsCount = readInt(stream);
    }

    @Override
    public String toString() {
        return "updateWebPage#7f891213";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
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
