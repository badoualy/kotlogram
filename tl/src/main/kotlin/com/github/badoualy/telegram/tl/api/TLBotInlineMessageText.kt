package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * botInlineMessageText#8c7f65e2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotInlineMessageText() : TLAbsBotInlineMessage() {
    @Transient
    var noWebpage: Boolean = false

    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    override var replyMarkup: TLAbsReplyMarkup? = null

    private val _constructor: String = "botInlineMessageText#8c7f65e2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            noWebpage: Boolean,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            replyMarkup: TLAbsReplyMarkup?
    ) : this() {
        this.noWebpage = noWebpage
        this.message = message
        this.entities = entities
        this.replyMarkup = replyMarkup
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(noWebpage, 1)
        updateFlags(entities, 2)
        updateFlags(replyMarkup, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(message)
        doIfMask(entities, 2) { writeTLVector(it) }
        doIfMask(replyMarkup, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        noWebpage = isMask(1)
        message = readString()
        entities = readIfMask(2) { readTLVector<TLAbsMessageEntity>() }
        replyMarkup = readIfMask(4) { readTLObject<TLAbsReplyMarkup>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(entities, 2) { it.computeSerializedSize() }
        size += getIntIfMask(replyMarkup, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotInlineMessageText) return false
        if (other === this) return true

        return _flags == other._flags
                && noWebpage == other.noWebpage
                && message == other.message
                && entities == other.entities
                && replyMarkup == other.replyMarkup
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8c7f65e2.toInt()
    }
}
