package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputPeerNotifySettings#38935eb2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPeerNotifySettings() : TLObject() {
    @Transient
    var showPreviews: Boolean = false

    @Transient
    var silent: Boolean = false

    var muteUntil: Int = 0

    var sound: String = ""

    private val _constructor: String = "inputPeerNotifySettings#38935eb2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            showPreviews: Boolean,
            silent: Boolean,
            muteUntil: Int,
            sound: String
    ) : this() {
        this.showPreviews = showPreviews
        this.silent = silent
        this.muteUntil = muteUntil
        this.sound = sound
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(showPreviews, 1)
        updateFlags(silent, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(muteUntil)
        writeString(sound)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        showPreviews = isMask(1)
        silent = isMask(2)
        muteUntil = readInt()
        sound = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(sound)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPeerNotifySettings) return false
        if (other === this) return true

        return _flags == other._flags
                && showPreviews == other.showPreviews
                && silent == other.silent
                && muteUntil == other.muteUntil
                && sound == other.sound
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x38935eb2.toInt()
    }
}
