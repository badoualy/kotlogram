package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channel#cb44b1c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannel() : TLAbsChat() {
    @Transient
    var creator: Boolean = false

    @Transient
    var left: Boolean = false

    @Transient
    var editor: Boolean = false

    @Transient
    var broadcast: Boolean = false

    @Transient
    var verified: Boolean = false

    @Transient
    var megagroup: Boolean = false

    @Transient
    var restricted: Boolean = false

    @Transient
    var democracy: Boolean = false

    @Transient
    var signatures: Boolean = false

    @Transient
    var min: Boolean = false

    override var id: Int = 0

    var accessHash: Long? = null

    var title: String = ""

    var username: String? = null

    var photo: TLAbsChatPhoto = TLChatPhotoEmpty()

    var date: Int = 0

    var version: Int = 0

    var restrictionReason: String? = null

    var adminRights: TLChannelAdminRights? = null

    var bannedRights: TLChannelBannedRights? = null

    private val _constructor: String = "channel#cb44b1c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            creator: Boolean,
            left: Boolean,
            editor: Boolean,
            broadcast: Boolean,
            verified: Boolean,
            megagroup: Boolean,
            restricted: Boolean,
            democracy: Boolean,
            signatures: Boolean,
            min: Boolean,
            id: Int,
            accessHash: Long?,
            title: String,
            username: String?,
            photo: TLAbsChatPhoto,
            date: Int,
            version: Int,
            restrictionReason: String?,
            adminRights: TLChannelAdminRights?,
            bannedRights: TLChannelBannedRights?
    ) : this() {
        this.creator = creator
        this.left = left
        this.editor = editor
        this.broadcast = broadcast
        this.verified = verified
        this.megagroup = megagroup
        this.restricted = restricted
        this.democracy = democracy
        this.signatures = signatures
        this.min = min
        this.id = id
        this.accessHash = accessHash
        this.title = title
        this.username = username
        this.photo = photo
        this.date = date
        this.version = version
        this.restrictionReason = restrictionReason
        this.adminRights = adminRights
        this.bannedRights = bannedRights
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(creator, 1)
        updateFlags(left, 4)
        updateFlags(editor, 8)
        updateFlags(broadcast, 32)
        updateFlags(verified, 128)
        updateFlags(megagroup, 256)
        updateFlags(restricted, 512)
        updateFlags(democracy, 1024)
        updateFlags(signatures, 2048)
        updateFlags(min, 4096)
        updateFlags(accessHash, 8192)
        updateFlags(username, 64)
        updateFlags(restrictionReason, 512)
        updateFlags(adminRights, 16384)
        updateFlags(bannedRights, 32768)

        // Following parameters might be forced to true by another field that updated the flags
        restricted = isMask(512)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        doIfMask(accessHash, 8192) { writeLong(it) }
        writeString(title)
        doIfMask(username, 64) { writeString(it) }
        writeTLObject(photo)
        writeInt(date)
        writeInt(version)
        doIfMask(restrictionReason, 512) { writeString(it) }
        doIfMask(adminRights, 16384) { writeTLObject(it) }
        doIfMask(bannedRights, 32768) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        creator = isMask(1)
        left = isMask(4)
        editor = isMask(8)
        broadcast = isMask(32)
        verified = isMask(128)
        megagroup = isMask(256)
        restricted = isMask(512)
        democracy = isMask(1024)
        signatures = isMask(2048)
        min = isMask(4096)
        id = readInt()
        accessHash = readIfMask(8192) { readLong() }
        title = readString()
        username = readIfMask(64) { readString() }
        photo = readTLObject<TLAbsChatPhoto>()
        date = readInt()
        version = readInt()
        restrictionReason = readIfMask(512) { readString() }
        adminRights = readIfMask(16384) { readTLObject<TLChannelAdminRights>(TLChannelAdminRights::class, TLChannelAdminRights.CONSTRUCTOR_ID) }
        bannedRights = readIfMask(32768) { readTLObject<TLChannelBannedRights>(TLChannelBannedRights::class, TLChannelBannedRights.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(accessHash, 8192) { SIZE_INT64 }
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(username, 64) { computeTLStringSerializedSize(it) }
        size += photo.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(restrictionReason, 512) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(adminRights, 16384) { it.computeSerializedSize() }
        size += getIntIfMask(bannedRights, 32768) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannel) return false
        if (other === this) return true

        return _flags == other._flags
                && creator == other.creator
                && left == other.left
                && editor == other.editor
                && broadcast == other.broadcast
                && verified == other.verified
                && megagroup == other.megagroup
                && restricted == other.restricted
                && democracy == other.democracy
                && signatures == other.signatures
                && min == other.min
                && id == other.id
                && accessHash == other.accessHash
                && title == other.title
                && username == other.username
                && photo == other.photo
                && date == other.date
                && version == other.version
                && restrictionReason == other.restrictionReason
                && adminRights == other.adminRights
                && bannedRights == other.bannedRights
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcb44b1c.toInt()
    }
}
