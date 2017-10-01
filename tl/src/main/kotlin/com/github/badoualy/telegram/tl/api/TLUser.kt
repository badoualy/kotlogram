package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * user#2e13f4c3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUser() : TLAbsUser() {
    @Transient
    var self: Boolean = false

    @Transient
    var contact: Boolean = false

    @Transient
    var mutualContact: Boolean = false

    @Transient
    var deleted: Boolean = false

    @Transient
    var bot: Boolean = false

    @Transient
    var botChatHistory: Boolean = false

    @Transient
    var botNochats: Boolean = false

    @Transient
    var verified: Boolean = false

    @Transient
    var restricted: Boolean = false

    @Transient
    var min: Boolean = false

    @Transient
    var botInlineGeo: Boolean = false

    override var id: Int = 0

    var accessHash: Long? = null

    var firstName: String? = null

    var lastName: String? = null

    var username: String? = null

    var phone: String? = null

    var photo: TLAbsUserProfilePhoto? = null

    var status: TLAbsUserStatus? = null

    var botInfoVersion: Int? = null

    var restrictionReason: String? = null

    var botInlinePlaceholder: String? = null

    var langCode: String? = null

    private val _constructor: String = "user#2e13f4c3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            self: Boolean,
            contact: Boolean,
            mutualContact: Boolean,
            deleted: Boolean,
            bot: Boolean,
            botChatHistory: Boolean,
            botNochats: Boolean,
            verified: Boolean,
            restricted: Boolean,
            min: Boolean,
            botInlineGeo: Boolean,
            id: Int,
            accessHash: Long?,
            firstName: String?,
            lastName: String?,
            username: String?,
            phone: String?,
            photo: TLAbsUserProfilePhoto?,
            status: TLAbsUserStatus?,
            botInfoVersion: Int?,
            restrictionReason: String?,
            botInlinePlaceholder: String?,
            langCode: String?
    ) : this() {
        this.self = self
        this.contact = contact
        this.mutualContact = mutualContact
        this.deleted = deleted
        this.bot = bot
        this.botChatHistory = botChatHistory
        this.botNochats = botNochats
        this.verified = verified
        this.restricted = restricted
        this.min = min
        this.botInlineGeo = botInlineGeo
        this.id = id
        this.accessHash = accessHash
        this.firstName = firstName
        this.lastName = lastName
        this.username = username
        this.phone = phone
        this.photo = photo
        this.status = status
        this.botInfoVersion = botInfoVersion
        this.restrictionReason = restrictionReason
        this.botInlinePlaceholder = botInlinePlaceholder
        this.langCode = langCode
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(self, 1024)
        updateFlags(contact, 2048)
        updateFlags(mutualContact, 4096)
        updateFlags(deleted, 8192)
        updateFlags(bot, 16384)
        updateFlags(botChatHistory, 32768)
        updateFlags(botNochats, 65536)
        updateFlags(verified, 131072)
        updateFlags(restricted, 262144)
        updateFlags(min, 1048576)
        updateFlags(botInlineGeo, 2097152)
        updateFlags(accessHash, 1)
        updateFlags(firstName, 2)
        updateFlags(lastName, 4)
        updateFlags(username, 8)
        updateFlags(phone, 16)
        updateFlags(photo, 32)
        updateFlags(status, 64)
        updateFlags(botInfoVersion, 16384)
        updateFlags(restrictionReason, 262144)
        updateFlags(botInlinePlaceholder, 524288)
        updateFlags(langCode, 4194304)

        // Following parameters might be forced to true by another field that updated the flags
        bot = isMask(16384)
        restricted = isMask(262144)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        doIfMask(accessHash, 1) { writeLong(it) }
        doIfMask(firstName, 2) { writeString(it) }
        doIfMask(lastName, 4) { writeString(it) }
        doIfMask(username, 8) { writeString(it) }
        doIfMask(phone, 16) { writeString(it) }
        doIfMask(photo, 32) { writeTLObject(it) }
        doIfMask(status, 64) { writeTLObject(it) }
        doIfMask(botInfoVersion, 16384) { writeInt(it) }
        doIfMask(restrictionReason, 262144) { writeString(it) }
        doIfMask(botInlinePlaceholder, 524288) { writeString(it) }
        doIfMask(langCode, 4194304) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        self = isMask(1024)
        contact = isMask(2048)
        mutualContact = isMask(4096)
        deleted = isMask(8192)
        bot = isMask(16384)
        botChatHistory = isMask(32768)
        botNochats = isMask(65536)
        verified = isMask(131072)
        restricted = isMask(262144)
        min = isMask(1048576)
        botInlineGeo = isMask(2097152)
        id = readInt()
        accessHash = readIfMask(1) { readLong() }
        firstName = readIfMask(2) { readString() }
        lastName = readIfMask(4) { readString() }
        username = readIfMask(8) { readString() }
        phone = readIfMask(16) { readString() }
        photo = readIfMask(32) { readTLObject<TLAbsUserProfilePhoto>() }
        status = readIfMask(64) { readTLObject<TLAbsUserStatus>() }
        botInfoVersion = readIfMask(16384) { readInt() }
        restrictionReason = readIfMask(262144) { readString() }
        botInlinePlaceholder = readIfMask(524288) { readString() }
        langCode = readIfMask(4194304) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(accessHash, 1) { SIZE_INT64 }
        size += getIntIfMask(firstName, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(lastName, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(username, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(phone, 16) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(photo, 32) { it.computeSerializedSize() }
        size += getIntIfMask(status, 64) { it.computeSerializedSize() }
        size += getIntIfMask(botInfoVersion, 16384) { SIZE_INT32 }
        size += getIntIfMask(restrictionReason, 262144) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(botInlinePlaceholder, 524288) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(langCode, 4194304) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUser) return false
        if (other === this) return true

        return _flags == other._flags
                && self == other.self
                && contact == other.contact
                && mutualContact == other.mutualContact
                && deleted == other.deleted
                && bot == other.bot
                && botChatHistory == other.botChatHistory
                && botNochats == other.botNochats
                && verified == other.verified
                && restricted == other.restricted
                && min == other.min
                && botInlineGeo == other.botInlineGeo
                && id == other.id
                && accessHash == other.accessHash
                && firstName == other.firstName
                && lastName == other.lastName
                && username == other.username
                && phone == other.phone
                && photo == other.photo
                && status == other.status
                && botInfoVersion == other.botInfoVersion
                && restrictionReason == other.restrictionReason
                && botInlinePlaceholder == other.botInlinePlaceholder
                && langCode == other.langCode
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2e13f4c3.toInt()
    }
}
