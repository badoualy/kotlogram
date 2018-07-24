package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * documentAttributeAudio#9852f9c6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDocumentAttributeAudio() : TLAbsDocumentAttribute() {
    @Transient
    var voice: Boolean = false

    var duration: Int = 0

    var title: String? = null

    var performer: String? = null

    var waveform: TLBytes? = null

    private val _constructor: String = "documentAttributeAudio#9852f9c6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            voice: Boolean,
            duration: Int,
            title: String?,
            performer: String?,
            waveform: TLBytes?
    ) : this() {
        this.voice = voice
        this.duration = duration
        this.title = title
        this.performer = performer
        this.waveform = waveform
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(voice, 1024)
        updateFlags(title, 1)
        updateFlags(performer, 2)
        updateFlags(waveform, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(duration)
        doIfMask(title, 1) { writeString(it) }
        doIfMask(performer, 2) { writeString(it) }
        doIfMask(waveform, 4) { writeTLBytes(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        voice = isMask(1024)
        duration = readInt()
        title = readIfMask(1) { readString() }
        performer = readIfMask(2) { readString() }
        waveform = readIfMask(4) { readTLBytes() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(title, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(performer, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(waveform, 4) { computeTLBytesSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDocumentAttributeAudio) return false
        if (other === this) return true

        return _flags == other._flags
                && voice == other.voice
                && duration == other.duration
                && title == other.title
                && performer == other.performer
                && waveform == other.waveform
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9852f9c6.toInt()
    }
}
