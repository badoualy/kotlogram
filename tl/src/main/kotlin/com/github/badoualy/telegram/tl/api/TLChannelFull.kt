package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * channelFull#76af5481
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelFull() : TLAbsChatFull() {
    @Transient
    var canViewParticipants: Boolean = false

    @Transient
    var canSetUsername: Boolean = false

    @Transient
    var canSetStickers: Boolean = false

    @Transient
    var hiddenPrehistory: Boolean = false

    override var id: Int = 0

    var about: String = ""

    var participantsCount: Int? = null

    var adminsCount: Int? = null

    var kickedCount: Int? = null

    var bannedCount: Int? = null

    var readInboxMaxId: Int = 0

    var readOutboxMaxId: Int = 0

    var unreadCount: Int = 0

    override var chatPhoto: TLAbsPhoto = TLPhotoEmpty()

    override var notifySettings: TLPeerNotifySettings = TLPeerNotifySettings()

    override var exportedInvite: TLAbsExportedChatInvite = TLChatInviteEmpty()

    override var botInfo: TLObjectVector<TLBotInfo> = TLObjectVector()

    var migratedFromChatId: Int? = null

    var migratedFromMaxId: Int? = null

    var pinnedMsgId: Int? = null

    var stickerset: TLStickerSet? = null

    var availableMinId: Int? = null

    private val _constructor: String = "channelFull#76af5481"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canViewParticipants: Boolean,
            canSetUsername: Boolean,
            canSetStickers: Boolean,
            hiddenPrehistory: Boolean,
            id: Int,
            about: String,
            participantsCount: Int?,
            adminsCount: Int?,
            kickedCount: Int?,
            bannedCount: Int?,
            readInboxMaxId: Int,
            readOutboxMaxId: Int,
            unreadCount: Int,
            chatPhoto: TLAbsPhoto,
            notifySettings: TLPeerNotifySettings,
            exportedInvite: TLAbsExportedChatInvite,
            botInfo: TLObjectVector<TLBotInfo>,
            migratedFromChatId: Int?,
            migratedFromMaxId: Int?,
            pinnedMsgId: Int?,
            stickerset: TLStickerSet?,
            availableMinId: Int?
    ) : this() {
        this.canViewParticipants = canViewParticipants
        this.canSetUsername = canSetUsername
        this.canSetStickers = canSetStickers
        this.hiddenPrehistory = hiddenPrehistory
        this.id = id
        this.about = about
        this.participantsCount = participantsCount
        this.adminsCount = adminsCount
        this.kickedCount = kickedCount
        this.bannedCount = bannedCount
        this.readInboxMaxId = readInboxMaxId
        this.readOutboxMaxId = readOutboxMaxId
        this.unreadCount = unreadCount
        this.chatPhoto = chatPhoto
        this.notifySettings = notifySettings
        this.exportedInvite = exportedInvite
        this.botInfo = botInfo
        this.migratedFromChatId = migratedFromChatId
        this.migratedFromMaxId = migratedFromMaxId
        this.pinnedMsgId = pinnedMsgId
        this.stickerset = stickerset
        this.availableMinId = availableMinId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(canViewParticipants, 8)
        updateFlags(canSetUsername, 64)
        updateFlags(canSetStickers, 128)
        updateFlags(hiddenPrehistory, 1024)
        updateFlags(participantsCount, 1)
        updateFlags(adminsCount, 2)
        updateFlags(kickedCount, 4)
        updateFlags(bannedCount, 4)
        updateFlags(migratedFromChatId, 16)
        updateFlags(migratedFromMaxId, 16)
        updateFlags(pinnedMsgId, 32)
        updateFlags(stickerset, 256)
        updateFlags(availableMinId, 512)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeString(about)
        doIfMask(participantsCount, 1) { writeInt(it) }
        doIfMask(adminsCount, 2) { writeInt(it) }
        doIfMask(kickedCount, 4) { writeInt(it) }
        doIfMask(bannedCount, 4) { writeInt(it) }
        writeInt(readInboxMaxId)
        writeInt(readOutboxMaxId)
        writeInt(unreadCount)
        writeTLObject(chatPhoto)
        writeTLObject(notifySettings)
        writeTLObject(exportedInvite)
        writeTLVector(botInfo)
        doIfMask(migratedFromChatId, 16) { writeInt(it) }
        doIfMask(migratedFromMaxId, 16) { writeInt(it) }
        doIfMask(pinnedMsgId, 32) { writeInt(it) }
        doIfMask(stickerset, 256) { writeTLObject(it) }
        doIfMask(availableMinId, 512) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canViewParticipants = isMask(8)
        canSetUsername = isMask(64)
        canSetStickers = isMask(128)
        hiddenPrehistory = isMask(1024)
        id = readInt()
        about = readString()
        participantsCount = readIfMask(1) { readInt() }
        adminsCount = readIfMask(2) { readInt() }
        kickedCount = readIfMask(4) { readInt() }
        bannedCount = readIfMask(4) { readInt() }
        readInboxMaxId = readInt()
        readOutboxMaxId = readInt()
        unreadCount = readInt()
        chatPhoto = readTLObject<TLAbsPhoto>()
        notifySettings = readTLObject<TLPeerNotifySettings>(TLPeerNotifySettings::class, TLPeerNotifySettings.CONSTRUCTOR_ID)
        exportedInvite = readTLObject<TLAbsExportedChatInvite>()
        botInfo = readTLVector<TLBotInfo>()
        migratedFromChatId = readIfMask(16) { readInt() }
        migratedFromMaxId = readIfMask(16) { readInt() }
        pinnedMsgId = readIfMask(32) { readInt() }
        stickerset = readIfMask(256) { readTLObject<TLStickerSet>(TLStickerSet::class, TLStickerSet.CONSTRUCTOR_ID) }
        availableMinId = readIfMask(512) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(about)
        size += getIntIfMask(participantsCount, 1) { SIZE_INT32 }
        size += getIntIfMask(adminsCount, 2) { SIZE_INT32 }
        size += getIntIfMask(kickedCount, 4) { SIZE_INT32 }
        size += getIntIfMask(bannedCount, 4) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += chatPhoto.computeSerializedSize()
        size += notifySettings.computeSerializedSize()
        size += exportedInvite.computeSerializedSize()
        size += botInfo.computeSerializedSize()
        size += getIntIfMask(migratedFromChatId, 16) { SIZE_INT32 }
        size += getIntIfMask(migratedFromMaxId, 16) { SIZE_INT32 }
        size += getIntIfMask(pinnedMsgId, 32) { SIZE_INT32 }
        size += getIntIfMask(stickerset, 256) { it.computeSerializedSize() }
        size += getIntIfMask(availableMinId, 512) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelFull) return false
        if (other === this) return true

        return _flags == other._flags
                && canViewParticipants == other.canViewParticipants
                && canSetUsername == other.canSetUsername
                && canSetStickers == other.canSetStickers
                && hiddenPrehistory == other.hiddenPrehistory
                && id == other.id
                && about == other.about
                && participantsCount == other.participantsCount
                && adminsCount == other.adminsCount
                && kickedCount == other.kickedCount
                && bannedCount == other.bannedCount
                && readInboxMaxId == other.readInboxMaxId
                && readOutboxMaxId == other.readOutboxMaxId
                && unreadCount == other.unreadCount
                && chatPhoto == other.chatPhoto
                && notifySettings == other.notifySettings
                && exportedInvite == other.exportedInvite
                && botInfo == other.botInfo
                && migratedFromChatId == other.migratedFromChatId
                && migratedFromMaxId == other.migratedFromMaxId
                && pinnedMsgId == other.pinnedMsgId
                && stickerset == other.stickerset
                && availableMinId == other.availableMinId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x76af5481.toInt()
    }
}
