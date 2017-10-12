package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsReportSpam() : TLMethod<TLBool>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var userId: TLAbsInputUser = TLInputUserEmpty()

    var id: TLIntVector = TLIntVector()

    private val _constructor: String = "channels.reportSpam#fe087810"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ) : this() {
        this.channel = channel
        this.userId = userId
        this.id = id
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(channel)
        writeTLObject(userId)
        writeTLVector(id)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channel = readTLObject<TLAbsInputChannel>()
        userId = readTLObject<TLAbsInputUser>()
        id = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += channel.computeSerializedSize()
        size += userId.computeSerializedSize()
        size += id.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsReportSpam) return false
        if (other === this) return true

        return channel == other.channel
                && userId == other.userId
                && id == other.id
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfe087810.toInt()
    }
}
