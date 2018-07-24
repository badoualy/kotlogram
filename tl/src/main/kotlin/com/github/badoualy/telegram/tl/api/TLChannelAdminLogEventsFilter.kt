package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * channelAdminLogEventsFilter#ea107ae4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventsFilter() : TLObject() {
    @Transient
    var join: Boolean = false

    @Transient
    var leave: Boolean = false

    @Transient
    var invite: Boolean = false

    @Transient
    var ban: Boolean = false

    @Transient
    var unban: Boolean = false

    @Transient
    var kick: Boolean = false

    @Transient
    var unkick: Boolean = false

    @Transient
    var promote: Boolean = false

    @Transient
    var demote: Boolean = false

    @Transient
    var info: Boolean = false

    @Transient
    var settings: Boolean = false

    @Transient
    var pinned: Boolean = false

    @Transient
    var edit: Boolean = false

    @Transient
    var delete: Boolean = false

    private val _constructor: String = "channelAdminLogEventsFilter#ea107ae4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            join: Boolean,
            leave: Boolean,
            invite: Boolean,
            ban: Boolean,
            unban: Boolean,
            kick: Boolean,
            unkick: Boolean,
            promote: Boolean,
            demote: Boolean,
            info: Boolean,
            settings: Boolean,
            pinned: Boolean,
            edit: Boolean,
            delete: Boolean
    ) : this() {
        this.join = join
        this.leave = leave
        this.invite = invite
        this.ban = ban
        this.unban = unban
        this.kick = kick
        this.unkick = unkick
        this.promote = promote
        this.demote = demote
        this.info = info
        this.settings = settings
        this.pinned = pinned
        this.edit = edit
        this.delete = delete
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(join, 1)
        updateFlags(leave, 2)
        updateFlags(invite, 4)
        updateFlags(ban, 8)
        updateFlags(unban, 16)
        updateFlags(kick, 32)
        updateFlags(unkick, 64)
        updateFlags(promote, 128)
        updateFlags(demote, 256)
        updateFlags(info, 512)
        updateFlags(settings, 1024)
        updateFlags(pinned, 2048)
        updateFlags(edit, 4096)
        updateFlags(delete, 8192)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        join = isMask(1)
        leave = isMask(2)
        invite = isMask(4)
        ban = isMask(8)
        unban = isMask(16)
        kick = isMask(32)
        unkick = isMask(64)
        promote = isMask(128)
        demote = isMask(256)
        info = isMask(512)
        settings = isMask(1024)
        pinned = isMask(2048)
        edit = isMask(4096)
        delete = isMask(8192)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventsFilter) return false
        if (other === this) return true

        return _flags == other._flags
                && join == other.join
                && leave == other.leave
                && invite == other.invite
                && ban == other.ban
                && unban == other.unban
                && kick == other.kick
                && unkick == other.unkick
                && promote == other.promote
                && demote == other.demote
                && info == other.info
                && settings == other.settings
                && pinned == other.pinned
                && edit == other.edit
                && delete == other.delete
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xea107ae4.toInt()
    }
}
