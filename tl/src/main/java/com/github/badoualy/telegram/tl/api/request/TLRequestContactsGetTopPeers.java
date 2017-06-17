package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestContactsGetTopPeers extends TLMethod<TLAbsTopPeers> {

    public static final int CONSTRUCTOR_ID = 0xd4982db5;

    protected int flags;

    protected boolean correspondents;

    protected boolean botsPm;

    protected boolean botsInline;

    protected boolean groups;

    protected boolean channels;

    protected int offset;

    protected int limit;

    protected int hash;

    private final String _constructor = "contacts.getTopPeers#d4982db5";

    public TLRequestContactsGetTopPeers() {
    }

    public TLRequestContactsGetTopPeers(boolean correspondents, boolean botsPm, boolean botsInline, boolean groups, boolean channels, int offset, int limit, int hash) {
        this.correspondents = correspondents;
        this.botsPm = botsPm;
        this.botsInline = botsInline;
        this.groups = groups;
        this.channels = channels;
        this.offset = offset;
        this.limit = limit;
        this.hash = hash;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsTopPeers deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsTopPeers)) {
            throw new IOException(
                    "Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response
                            .getClass().getCanonicalName());
        }
        return (TLAbsTopPeers) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = correspondents ? (flags | 1) : (flags & ~1);
        flags = botsPm ? (flags | 2) : (flags & ~2);
        flags = botsInline ? (flags | 4) : (flags & ~4);
        flags = groups ? (flags | 1024) : (flags & ~1024);
        flags = channels ? (flags | 32768) : (flags & ~32768);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(offset, stream);
        writeInt(limit, stream);
        writeInt(hash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        correspondents = (flags & 1) != 0;
        botsPm = (flags & 2) != 0;
        botsInline = (flags & 4) != 0;
        groups = (flags & 1024) != 0;
        channels = (flags & 32768) != 0;
        offset = readInt(stream);
        limit = readInt(stream);
        hash = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public boolean getCorrespondents() {
        return correspondents;
    }

    public void setCorrespondents(boolean correspondents) {
        this.correspondents = correspondents;
    }

    public boolean getBotsPm() {
        return botsPm;
    }

    public void setBotsPm(boolean botsPm) {
        this.botsPm = botsPm;
    }

    public boolean getBotsInline() {
        return botsInline;
    }

    public void setBotsInline(boolean botsInline) {
        this.botsInline = botsInline;
    }

    public boolean getGroups() {
        return groups;
    }

    public void setGroups(boolean groups) {
        this.groups = groups;
    }

    public boolean getChannels() {
        return channels;
    }

    public void setChannels(boolean channels) {
        this.channels = channels;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
}
