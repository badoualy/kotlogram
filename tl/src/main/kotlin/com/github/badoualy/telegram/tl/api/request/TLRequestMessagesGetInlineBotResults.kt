package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.api.messages.TLBotResults
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetInlineBotResults() : TLMethod<TLBotResults>() {
    var bot: TLAbsInputUser = TLInputUserEmpty()

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var geoPoint: TLAbsInputGeoPoint? = null

    var query: String = ""

    var offset: String = ""

    private val _constructor: String = "messages.getInlineBotResults#514e999d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ) : this() {
        this.bot = bot
        this.peer = peer
        this.geoPoint = geoPoint
        this.query = query
        this.offset = offset
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLBotResults = tlDeserializer.readTLObject(TLBotResults::class, TLBotResults.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(geoPoint, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(bot)
        writeTLObject(peer)
        doIfMask(geoPoint, 1) { writeTLObject(it) }
        writeString(query)
        writeString(offset)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        bot = readTLObject<TLAbsInputUser>()
        peer = readTLObject<TLAbsInputPeer>()
        geoPoint = readIfMask(1) { readTLObject<TLAbsInputGeoPoint>() }
        query = readString()
        offset = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += bot.computeSerializedSize()
        size += peer.computeSerializedSize()
        size += getIntIfMask(geoPoint, 1) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(query)
        size += computeTLStringSerializedSize(offset)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetInlineBotResults) return false
        if (other === this) return true

        return _flags == other._flags
                && bot == other.bot
                && peer == other.peer
                && geoPoint == other.geoPoint
                && query == other.query
                && offset == other.offset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x514e999d.toInt()
    }
}
