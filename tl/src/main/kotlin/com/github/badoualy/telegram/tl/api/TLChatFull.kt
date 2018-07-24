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

/**
 * chatFull#2e02a614
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatFull() : TLAbsChatFull() {
    override var id: Int = 0

    var participants: TLAbsChatParticipants = TLChatParticipants()

    override var chatPhoto: TLAbsPhoto = TLPhotoEmpty()

    override var notifySettings: TLPeerNotifySettings = TLPeerNotifySettings()

    override var exportedInvite: TLAbsExportedChatInvite = TLChatInviteEmpty()

    override var botInfo: TLObjectVector<TLBotInfo> = TLObjectVector()

    private val _constructor: String = "chatFull#2e02a614"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Int,
            participants: TLAbsChatParticipants,
            chatPhoto: TLAbsPhoto,
            notifySettings: TLPeerNotifySettings,
            exportedInvite: TLAbsExportedChatInvite,
            botInfo: TLObjectVector<TLBotInfo>
    ) : this() {
        this.id = id
        this.participants = participants
        this.chatPhoto = chatPhoto
        this.notifySettings = notifySettings
        this.exportedInvite = exportedInvite
        this.botInfo = botInfo
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(id)
        writeTLObject(participants)
        writeTLObject(chatPhoto)
        writeTLObject(notifySettings)
        writeTLObject(exportedInvite)
        writeTLVector(botInfo)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readInt()
        participants = readTLObject<TLAbsChatParticipants>()
        chatPhoto = readTLObject<TLAbsPhoto>()
        notifySettings = readTLObject<TLPeerNotifySettings>(TLPeerNotifySettings::class, TLPeerNotifySettings.CONSTRUCTOR_ID)
        exportedInvite = readTLObject<TLAbsExportedChatInvite>()
        botInfo = readTLVector<TLBotInfo>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += participants.computeSerializedSize()
        size += chatPhoto.computeSerializedSize()
        size += notifySettings.computeSerializedSize()
        size += exportedInvite.computeSerializedSize()
        size += botInfo.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatFull) return false
        if (other === this) return true

        return id == other.id
                && participants == other.participants
                && chatPhoto == other.chatPhoto
                && notifySettings == other.notifySettings
                && exportedInvite == other.exportedInvite
                && botInfo == other.botInfo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2e02a614.toInt()
    }
}
