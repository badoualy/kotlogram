package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputBotInlineResult
import com.github.badoualy.telegram.tl.api.TLInlineBotSwitchPM
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSetInlineBotResults() : TLMethod<TLBool>() {
    @Transient
    var gallery: Boolean = false

    @Transient
    var _private: Boolean = false

    var queryId: Long = 0L

    var results: TLObjectVector<TLAbsInputBotInlineResult> = TLObjectVector()

    var cacheTime: Int = 0

    var nextOffset: String? = null

    var switchPm: TLInlineBotSwitchPM? = null

    private val _constructor: String = "messages.setInlineBotResults#eb5ea206"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?
    ) : this() {
        this.gallery = gallery
        this._private = _private
        this.queryId = queryId
        this.results = results
        this.cacheTime = cacheTime
        this.nextOffset = nextOffset
        this.switchPm = switchPm
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(gallery, 1)
        updateFlags(_private, 2)
        updateFlags(nextOffset, 4)
        updateFlags(switchPm, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(queryId)
        writeTLVector(results)
        writeInt(cacheTime)
        doIfMask(nextOffset, 4) { writeString(it) }
        doIfMask(switchPm, 8) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        gallery = isMask(1)
        _private = isMask(2)
        queryId = readLong()
        results = readTLVector<TLAbsInputBotInlineResult>()
        cacheTime = readInt()
        nextOffset = readIfMask(4) { readString() }
        switchPm = readIfMask(8) { readTLObject<TLInlineBotSwitchPM>(TLInlineBotSwitchPM::class, TLInlineBotSwitchPM.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += results.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(nextOffset, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(switchPm, 8) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSetInlineBotResults) return false
        if (other === this) return true

        return _flags == other._flags
                && gallery == other.gallery
                && _private == other._private
                && queryId == other.queryId
                && results == other.results
                && cacheTime == other.cacheTime
                && nextOffset == other.nextOffset
                && switchPm == other.switchPm
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xeb5ea206.toInt()
    }
}
