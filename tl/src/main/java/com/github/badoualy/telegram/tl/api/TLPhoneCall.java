package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPhoneCall extends TLAbsPhoneCall {

    public static final int CONSTRUCTOR_ID = 0xffe6ab67;

    protected long accessHash;

    protected int date;

    protected int adminId;

    protected int participantId;

    protected TLBytes gAOrB;

    protected long keyFingerprint;

    protected TLPhoneCallProtocol protocol;

    protected TLPhoneConnection connection;

    protected TLVector<TLPhoneConnection> alternativeConnections;

    protected int startDate;

    private final String _constructor = "phoneCall#ffe6ab67";

    public TLPhoneCall() {
    }

    public TLPhoneCall(long id, long accessHash, int date, int adminId, int participantId, TLBytes gAOrB, long keyFingerprint, TLPhoneCallProtocol protocol, TLPhoneConnection connection, TLVector<TLPhoneConnection> alternativeConnections, int startDate) {
        this.id = id;
        this.accessHash = accessHash;
        this.date = date;
        this.adminId = adminId;
        this.participantId = participantId;
        this.gAOrB = gAOrB;
        this.keyFingerprint = keyFingerprint;
        this.protocol = protocol;
        this.connection = connection;
        this.alternativeConnections = alternativeConnections;
        this.startDate = startDate;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeInt(date, stream);
        writeInt(adminId, stream);
        writeInt(participantId, stream);
        writeTLBytes(gAOrB, stream);
        writeLong(keyFingerprint, stream);
        writeTLObject(protocol, stream);
        writeTLObject(connection, stream);
        writeTLVector(alternativeConnections, stream);
        writeInt(startDate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        accessHash = readLong(stream);
        date = readInt(stream);
        adminId = readInt(stream);
        participantId = readInt(stream);
        gAOrB = readTLBytes(stream, context);
        keyFingerprint = readLong(stream);
        protocol = readTLObject(stream, context, TLPhoneCallProtocol.class, TLPhoneCallProtocol.CONSTRUCTOR_ID);
        connection = readTLObject(stream, context, TLPhoneConnection.class, TLPhoneConnection.CONSTRUCTOR_ID);
        alternativeConnections = readTLVector(stream, context);
        startDate = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(gAOrB);
        size += SIZE_INT64;
        size += protocol.computeSerializedSize();
        size += connection.computeSerializedSize();
        size += alternativeConnections.computeSerializedSize();
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public TLBytes getGAOrB() {
        return gAOrB;
    }

    public void setGAOrB(TLBytes gAOrB) {
        this.gAOrB = gAOrB;
    }

    public long getKeyFingerprint() {
        return keyFingerprint;
    }

    public void setKeyFingerprint(long keyFingerprint) {
        this.keyFingerprint = keyFingerprint;
    }

    public TLPhoneCallProtocol getProtocol() {
        return protocol;
    }

    public void setProtocol(TLPhoneCallProtocol protocol) {
        this.protocol = protocol;
    }

    public TLPhoneConnection getConnection() {
        return connection;
    }

    public void setConnection(TLPhoneConnection connection) {
        this.connection = connection;
    }

    public TLVector<TLPhoneConnection> getAlternativeConnections() {
        return alternativeConnections;
    }

    public void setAlternativeConnections(TLVector<TLPhoneConnection> alternativeConnections) {
        this.alternativeConnections = alternativeConnections;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }
}
