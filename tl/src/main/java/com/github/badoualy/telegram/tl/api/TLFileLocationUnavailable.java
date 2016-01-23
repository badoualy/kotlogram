package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileLocationUnavailable extends TLAbsFileLocation {
    public static final int CLASS_ID = 0x7c596b46;

    protected long volumeId;

    protected int localId;

    protected long secret;

    public TLFileLocationUnavailable() {
    }

    public TLFileLocationUnavailable(long volumeId, int localId, long secret) {
        this.volumeId = volumeId;
        this.localId = localId;
        this.secret = secret;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(volumeId, stream);
        writeInt(localId, stream);
        writeLong(secret, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        volumeId = readLong(stream);
        localId = readInt(stream);
        secret = readLong(stream);
    }

    @Override
    public String toString() {
        return "fileLocationUnavailable#7c596b46";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public long getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(long volumeId) {
        this.volumeId = volumeId;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public long getSecret() {
        return secret;
    }

    public void setSecret(long secret) {
        this.secret = secret;
    }
}
