package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * chat#d91cdd54
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChat() : TLAbsChat() {
    @Transient
    var creator: Boolean = false

    @Transient
    var kicked: Boolean = false

    @Transient
    var left: Boolean = false

    @Transient
    var adminsEnabled: Boolean = false

    @Transient
    var admin: Boolean = false

    @Transient
    var deactivated: Boolean = false

    override var id: Int = 0

    var title: String = ""

    var photo: TLAbsChatPhoto = TLChatPhotoEmpty()

    var participantsCount: Int = 0

    var date: Int = 0

    var version: Int = 0

    var migratedTo: TLAbsInputChannel? = null

    private val _constructor: String = "chat#d91cdd54"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            creator: Boolean,
            kicked: Boolean,
            left: Boolean,
            adminsEnabled: Boolean,
            admin: Boolean,
            deactivated: Boolean,
            id: Int,
            title: String,
            photo: TLAbsChatPhoto,
            participantsCount: Int,
            date: Int,
            version: Int,
            migratedTo: TLAbsInputChannel?
    ) : this() {
        this.creator = creator
        this.kicked = kicked
        this.left = left
        this.adminsEnabled = adminsEnabled
        this.admin = admin
        this.deactivated = deactivated
        this.id = id
        this.title = title
        this.photo = photo
        this.participantsCount = participantsCount
        this.date = date
        this.version = version
        this.migratedTo = migratedTo
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(creator, 1)
        updateFlags(kicked, 2)
        updateFlags(left, 4)
        updateFlags(adminsEnabled, 8)
        updateFlags(admin, 16)
        updateFlags(deactivated, 32)
        updateFlags(migratedTo, 64)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeString(title)
        writeTLObject(photo)
        writeInt(participantsCount)
        writeInt(date)
        writeInt(version)
        doIfMask(migratedTo, 64) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        creator = isMask(1)
        kicked = isMask(2)
        left = isMask(4)
        adminsEnabled = isMask(8)
        admin = isMask(16)
        deactivated = isMask(32)
        id = readInt()
        title = readString()
        photo = readTLObject<TLAbsChatPhoto>()
        participantsCount = readInt()
        date = readInt()
        version = readInt()
        migratedTo = readIfMask(64) { readTLObject<TLAbsInputChannel>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += photo.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(migratedTo, 64) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChat) return false
        if (other === this) return true

        return _flags == other._flags
                && creator == other.creator
                && kicked == other.kicked
                && left == other.left
                && adminsEnabled == other.adminsEnabled
                && admin == other.admin
                && deactivated == other.deactivated
                && id == other.id
                && title == other.title
                && photo == other.photo
                && participantsCount == other.participantsCount
                && date == other.date
                && version == other.version
                && migratedTo == other.migratedTo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd91cdd54.toInt()
    }
}
