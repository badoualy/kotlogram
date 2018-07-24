package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.contacts.TLLink
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
 * userFull#f220f3f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserFull() : TLObject() {
    @Transient
    var blocked: Boolean = false

    @Transient
    var phoneCallsAvailable: Boolean = false

    @Transient
    var phoneCallsPrivate: Boolean = false

    var user: TLAbsUser = TLUserEmpty()

    var about: String? = null

    var link: TLLink = TLLink()

    var profilePhoto: TLAbsPhoto? = null

    var notifySettings: TLPeerNotifySettings = TLPeerNotifySettings()

    var botInfo: TLBotInfo? = null

    var commonChatsCount: Int = 0

    private val _constructor: String = "userFull#f220f3f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            blocked: Boolean,
            phoneCallsAvailable: Boolean,
            phoneCallsPrivate: Boolean,
            user: TLAbsUser,
            about: String?,
            link: TLLink,
            profilePhoto: TLAbsPhoto?,
            notifySettings: TLPeerNotifySettings,
            botInfo: TLBotInfo?,
            commonChatsCount: Int
    ) : this() {
        this.blocked = blocked
        this.phoneCallsAvailable = phoneCallsAvailable
        this.phoneCallsPrivate = phoneCallsPrivate
        this.user = user
        this.about = about
        this.link = link
        this.profilePhoto = profilePhoto
        this.notifySettings = notifySettings
        this.botInfo = botInfo
        this.commonChatsCount = commonChatsCount
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(blocked, 1)
        updateFlags(phoneCallsAvailable, 16)
        updateFlags(phoneCallsPrivate, 32)
        updateFlags(about, 2)
        updateFlags(profilePhoto, 4)
        updateFlags(botInfo, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(user)
        doIfMask(about, 2) { writeString(it) }
        writeTLObject(link)
        doIfMask(profilePhoto, 4) { writeTLObject(it) }
        writeTLObject(notifySettings)
        doIfMask(botInfo, 8) { writeTLObject(it) }
        writeInt(commonChatsCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        blocked = isMask(1)
        phoneCallsAvailable = isMask(16)
        phoneCallsPrivate = isMask(32)
        user = readTLObject<TLAbsUser>()
        about = readIfMask(2) { readString() }
        link = readTLObject<TLLink>(TLLink::class, TLLink.CONSTRUCTOR_ID)
        profilePhoto = readIfMask(4) { readTLObject<TLAbsPhoto>() }
        notifySettings = readTLObject<TLPeerNotifySettings>(TLPeerNotifySettings::class, TLPeerNotifySettings.CONSTRUCTOR_ID)
        botInfo = readIfMask(8) { readTLObject<TLBotInfo>(TLBotInfo::class, TLBotInfo.CONSTRUCTOR_ID) }
        commonChatsCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += user.computeSerializedSize()
        size += getIntIfMask(about, 2) { computeTLStringSerializedSize(it) }
        size += link.computeSerializedSize()
        size += getIntIfMask(profilePhoto, 4) { it.computeSerializedSize() }
        size += notifySettings.computeSerializedSize()
        size += getIntIfMask(botInfo, 8) { it.computeSerializedSize() }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserFull) return false
        if (other === this) return true

        return _flags == other._flags
                && blocked == other.blocked
                && phoneCallsAvailable == other.phoneCallsAvailable
                && phoneCallsPrivate == other.phoneCallsPrivate
                && user == other.user
                && about == other.about
                && link == other.link
                && profilePhoto == other.profilePhoto
                && notifySettings == other.notifySettings
                && botInfo == other.botInfo
                && commonChatsCount == other.commonChatsCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf220f3f.toInt()
    }
}
