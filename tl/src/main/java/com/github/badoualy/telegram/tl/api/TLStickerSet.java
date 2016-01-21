
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
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLStickerSet extends TLObject {

    public static final int CLASS_ID = 0xcd303b41;

    public TLStickerSet() {

    }


    public TLStickerSet(        int _flags,         boolean _installed,         boolean _disabled,         boolean _official,         long _id,         long _accessHash,         String _title,         String _shortName,         int _count,         int _hash) {
        this.flags = _flags;
        this.installed = _installed;
        this.disabled = _disabled;
        this.official = _official;
        this.id = _id;
        this.accessHash = _accessHash;
        this.title = _title;
        this.shortName = _shortName;
        this.count = _count;
        this.hash = _hash;

    }


    public int getClassId() {
        return CLASS_ID;
    }


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


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getInstalled() {
        return installed;
    }

    public void setInstalled(boolean value) {
        this.installed = value;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean value) {
        this.disabled = value;
    }

    public boolean getOfficial() {
        return official;
    }

    public void setOfficial(boolean value) {
        this.official = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String value) {
        this.shortName = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int value) {
        this.hash = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = installed ? (flags | 1) : (flags &~ 1);
        flags = disabled ? (flags | 2) : (flags &~ 2);
        flags = official ? (flags | 4) : (flags &~ 4);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.installed, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.disabled, stream);
        if ((this.flags & 4) != 0)
            writeTLBool(this.official, stream);
        writeLong(this.id, stream);
        writeLong(this.accessHash, stream);
        writeTLString(this.title, stream);
        writeTLString(this.shortName, stream);
        writeInt(this.count, stream);
        writeInt(this.hash, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.installed = (this.flags & 1) != 0;
        this.disabled = (this.flags & 2) != 0;
        this.official = (this.flags & 4) != 0;
        this.id = readLong(stream);
        this.accessHash = readLong(stream);
        this.title = readTLString(stream);
        this.shortName = readTLString(stream);
        this.count = readInt(stream);
        this.hash = readInt(stream);
    }


    @Override
    public String toString() {
        return "stickerSet#cd303b41";
    }

}
