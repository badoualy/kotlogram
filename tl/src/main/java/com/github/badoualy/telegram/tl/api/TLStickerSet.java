package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStickerSet extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xcd303b41;

    protected int flags;

    protected boolean installed;

    protected boolean disabled;

    protected boolean official;

    protected long id;

    protected long accessHash;

    protected String title;

    protected String shortName;

    protected int count;

    protected int hash;

    public TLStickerSet() {
    }

    public TLStickerSet(boolean installed, boolean disabled, boolean official, long id, long accessHash, String title, String shortName, int count, int hash) {
        this.installed = installed;
        this.disabled = disabled;
        this.official = official;
        this.id = id;
        this.accessHash = accessHash;
        this.title = title;
        this.shortName = shortName;
        this.count = count;
        this.hash = hash;
    }

    private void computeFlags() {
        flags = 0;
        flags = installed ? (flags | 1) : (flags &~ 1);
        flags = disabled ? (flags | 2) : (flags &~ 2);
        flags = official ? (flags | 4) : (flags &~ 4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeString(title, stream);
        writeString(shortName, stream);
        writeInt(count, stream);
        writeInt(hash, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        installed = (flags & 1) != 0;
        disabled = (flags & 2) != 0;
        official = (flags & 4) != 0;
        id = readLong(stream);
        accessHash = readLong(stream);
        title = readTLString(stream);
        shortName = readTLString(stream);
        count = readInt(stream);
        hash = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(shortName);
        size += SIZE_INT32;
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return "stickerSet#cd303b41";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLStickerSet)) return false;
        if (object == this) return true;

        TLStickerSet o = (TLStickerSet) object;

        return flags == o.flags
                && installed == o.installed
                && disabled == o.disabled
                && official == o.official
                && id == o.id
                && accessHash == o.accessHash
                && (title == o.title || (title != null && o.title != null && title.equals(o.title)))
                && (shortName == o.shortName || (shortName != null && o.shortName != null && shortName.equals(o.shortName)))
                && count == o.count
                && hash == o.hash;
    }

    public boolean getInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean getOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
}
