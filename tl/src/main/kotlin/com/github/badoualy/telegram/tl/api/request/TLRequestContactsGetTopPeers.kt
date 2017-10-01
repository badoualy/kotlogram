package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestContactsGetTopPeers() : TLMethod<TLAbsTopPeers>() {
    @Transient
    var correspondents: Boolean = false

    @Transient
    var botsPm: Boolean = false

    @Transient
    var botsInline: Boolean = false

    @Transient
    var phoneCalls: Boolean = false

    @Transient
    var groups: Boolean = false

    @Transient
    var channels: Boolean = false

    var offset: Int = 0

    var limit: Int = 0

    var hash: Int = 0

    private val _constructor: String = "contacts.getTopPeers#d4982db5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            correspondents: Boolean,
            botsPm: Boolean,
            botsInline: Boolean,
            phoneCalls: Boolean,
            groups: Boolean,
            channels: Boolean,
            offset: Int,
            limit: Int,
            hash: Int
    ) : this() {
        this.correspondents = correspondents
        this.botsPm = botsPm
        this.botsInline = botsInline
        this.phoneCalls = phoneCalls
        this.groups = groups
        this.channels = channels
        this.offset = offset
        this.limit = limit
        this.hash = hash
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLAbsTopPeers = tlDeserializer.readTLObject()

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(correspondents, 1)
        updateFlags(botsPm, 2)
        updateFlags(botsInline, 4)
        updateFlags(phoneCalls, 8)
        updateFlags(groups, 1024)
        updateFlags(channels, 32768)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(offset)
        writeInt(limit)
        writeInt(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        correspondents = isMask(1)
        botsPm = isMask(2)
        botsInline = isMask(4)
        phoneCalls = isMask(8)
        groups = isMask(1024)
        channels = isMask(32768)
        offset = readInt()
        limit = readInt()
        hash = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestContactsGetTopPeers) return false
        if (other === this) return true

        return _flags == other._flags
                && correspondents == other.correspondents
                && botsPm == other.botsPm
                && botsInline == other.botsInline
                && phoneCalls == other.phoneCalls
                && groups == other.groups
                && channels == other.channels
                && offset == other.offset
                && limit == other.limit
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd4982db5.toInt()
    }
}
