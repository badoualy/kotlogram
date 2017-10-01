package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsBotInlineResult
import com.github.badoualy.telegram.tl.api.TLInlineBotSwitchPM
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.botResults#ccd3563d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotResults() : TLObject() {
    @Transient
    var gallery: Boolean = false

    var queryId: Long = 0L

    var nextOffset: String? = null

    var switchPm: TLInlineBotSwitchPM? = null

    var results: TLObjectVector<TLAbsBotInlineResult> = TLObjectVector()

    var cacheTime: Int = 0

    private val _constructor: String = "messages.botResults#ccd3563d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            gallery: Boolean,
            queryId: Long,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?,
            results: TLObjectVector<TLAbsBotInlineResult>,
            cacheTime: Int
    ) : this() {
        this.gallery = gallery
        this.queryId = queryId
        this.nextOffset = nextOffset
        this.switchPm = switchPm
        this.results = results
        this.cacheTime = cacheTime
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(gallery, 1)
        updateFlags(nextOffset, 2)
        updateFlags(switchPm, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(queryId)
        doIfMask(nextOffset, 2) { writeString(it) }
        doIfMask(switchPm, 4) { writeTLObject(it) }
        writeTLVector(results)
        writeInt(cacheTime)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        gallery = isMask(1)
        queryId = readLong()
        nextOffset = readIfMask(2) { readString() }
        switchPm = readIfMask(4) { readTLObject<TLInlineBotSwitchPM>(TLInlineBotSwitchPM::class, TLInlineBotSwitchPM.CONSTRUCTOR_ID) }
        results = readTLVector<TLAbsBotInlineResult>()
        cacheTime = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(nextOffset, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(switchPm, 4) { it.computeSerializedSize() }
        size += results.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotResults) return false
        if (other === this) return true

        return _flags == other._flags
                && gallery == other.gallery
                && queryId == other.queryId
                && nextOffset == other.nextOffset
                && switchPm == other.switchPm
                && results == other.results
                && cacheTime == other.cacheTime
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xccd3563d.toInt()
    }
}
