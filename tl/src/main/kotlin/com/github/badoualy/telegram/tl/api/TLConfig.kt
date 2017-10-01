package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * config#8df376a4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLConfig() : TLObject() {
    @Transient
    var phonecallsEnabled: Boolean = false

    var date: Int = 0

    var expires: Int = 0

    var testMode: Boolean = false

    var thisDc: Int = 0

    var dcOptions: TLObjectVector<TLDcOption> = TLObjectVector()

    var chatSizeMax: Int = 0

    var megagroupSizeMax: Int = 0

    var forwardedCountMax: Int = 0

    var onlineUpdatePeriodMs: Int = 0

    var offlineBlurTimeoutMs: Int = 0

    var offlineIdleTimeoutMs: Int = 0

    var onlineCloudTimeoutMs: Int = 0

    var notifyCloudDelayMs: Int = 0

    var notifyDefaultDelayMs: Int = 0

    var chatBigSize: Int = 0

    var pushChatPeriodMs: Int = 0

    var pushChatLimit: Int = 0

    var savedGifsLimit: Int = 0

    var editTimeLimit: Int = 0

    var ratingEDecay: Int = 0

    var stickersRecentLimit: Int = 0

    var stickersFavedLimit: Int = 0

    var tmpSessions: Int? = null

    var pinnedDialogsCountMax: Int = 0

    var callReceiveTimeoutMs: Int = 0

    var callRingTimeoutMs: Int = 0

    var callConnectTimeoutMs: Int = 0

    var callPacketTimeoutMs: Int = 0

    var meUrlPrefix: String = ""

    var suggestedLangCode: String? = null

    var langPackVersion: Int? = null

    var disabledFeatures: TLObjectVector<TLDisabledFeature> = TLObjectVector()

    private val _constructor: String = "config#8df376a4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phonecallsEnabled: Boolean,
            date: Int,
            expires: Int,
            testMode: Boolean,
            thisDc: Int,
            dcOptions: TLObjectVector<TLDcOption>,
            chatSizeMax: Int,
            megagroupSizeMax: Int,
            forwardedCountMax: Int,
            onlineUpdatePeriodMs: Int,
            offlineBlurTimeoutMs: Int,
            offlineIdleTimeoutMs: Int,
            onlineCloudTimeoutMs: Int,
            notifyCloudDelayMs: Int,
            notifyDefaultDelayMs: Int,
            chatBigSize: Int,
            pushChatPeriodMs: Int,
            pushChatLimit: Int,
            savedGifsLimit: Int,
            editTimeLimit: Int,
            ratingEDecay: Int,
            stickersRecentLimit: Int,
            stickersFavedLimit: Int,
            tmpSessions: Int?,
            pinnedDialogsCountMax: Int,
            callReceiveTimeoutMs: Int,
            callRingTimeoutMs: Int,
            callConnectTimeoutMs: Int,
            callPacketTimeoutMs: Int,
            meUrlPrefix: String,
            suggestedLangCode: String?,
            langPackVersion: Int?,
            disabledFeatures: TLObjectVector<TLDisabledFeature>
    ) : this() {
        this.phonecallsEnabled = phonecallsEnabled
        this.date = date
        this.expires = expires
        this.testMode = testMode
        this.thisDc = thisDc
        this.dcOptions = dcOptions
        this.chatSizeMax = chatSizeMax
        this.megagroupSizeMax = megagroupSizeMax
        this.forwardedCountMax = forwardedCountMax
        this.onlineUpdatePeriodMs = onlineUpdatePeriodMs
        this.offlineBlurTimeoutMs = offlineBlurTimeoutMs
        this.offlineIdleTimeoutMs = offlineIdleTimeoutMs
        this.onlineCloudTimeoutMs = onlineCloudTimeoutMs
        this.notifyCloudDelayMs = notifyCloudDelayMs
        this.notifyDefaultDelayMs = notifyDefaultDelayMs
        this.chatBigSize = chatBigSize
        this.pushChatPeriodMs = pushChatPeriodMs
        this.pushChatLimit = pushChatLimit
        this.savedGifsLimit = savedGifsLimit
        this.editTimeLimit = editTimeLimit
        this.ratingEDecay = ratingEDecay
        this.stickersRecentLimit = stickersRecentLimit
        this.stickersFavedLimit = stickersFavedLimit
        this.tmpSessions = tmpSessions
        this.pinnedDialogsCountMax = pinnedDialogsCountMax
        this.callReceiveTimeoutMs = callReceiveTimeoutMs
        this.callRingTimeoutMs = callRingTimeoutMs
        this.callConnectTimeoutMs = callConnectTimeoutMs
        this.callPacketTimeoutMs = callPacketTimeoutMs
        this.meUrlPrefix = meUrlPrefix
        this.suggestedLangCode = suggestedLangCode
        this.langPackVersion = langPackVersion
        this.disabledFeatures = disabledFeatures
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(phonecallsEnabled, 2)
        updateFlags(tmpSessions, 1)
        updateFlags(suggestedLangCode, 4)
        updateFlags(langPackVersion, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(date)
        writeInt(expires)
        writeBoolean(testMode)
        writeInt(thisDc)
        writeTLVector(dcOptions)
        writeInt(chatSizeMax)
        writeInt(megagroupSizeMax)
        writeInt(forwardedCountMax)
        writeInt(onlineUpdatePeriodMs)
        writeInt(offlineBlurTimeoutMs)
        writeInt(offlineIdleTimeoutMs)
        writeInt(onlineCloudTimeoutMs)
        writeInt(notifyCloudDelayMs)
        writeInt(notifyDefaultDelayMs)
        writeInt(chatBigSize)
        writeInt(pushChatPeriodMs)
        writeInt(pushChatLimit)
        writeInt(savedGifsLimit)
        writeInt(editTimeLimit)
        writeInt(ratingEDecay)
        writeInt(stickersRecentLimit)
        writeInt(stickersFavedLimit)
        doIfMask(tmpSessions, 1) { writeInt(it) }
        writeInt(pinnedDialogsCountMax)
        writeInt(callReceiveTimeoutMs)
        writeInt(callRingTimeoutMs)
        writeInt(callConnectTimeoutMs)
        writeInt(callPacketTimeoutMs)
        writeString(meUrlPrefix)
        doIfMask(suggestedLangCode, 4) { writeString(it) }
        doIfMask(langPackVersion, 4) { writeInt(it) }
        writeTLVector(disabledFeatures)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        phonecallsEnabled = isMask(2)
        date = readInt()
        expires = readInt()
        testMode = readBoolean()
        thisDc = readInt()
        dcOptions = readTLVector<TLDcOption>()
        chatSizeMax = readInt()
        megagroupSizeMax = readInt()
        forwardedCountMax = readInt()
        onlineUpdatePeriodMs = readInt()
        offlineBlurTimeoutMs = readInt()
        offlineIdleTimeoutMs = readInt()
        onlineCloudTimeoutMs = readInt()
        notifyCloudDelayMs = readInt()
        notifyDefaultDelayMs = readInt()
        chatBigSize = readInt()
        pushChatPeriodMs = readInt()
        pushChatLimit = readInt()
        savedGifsLimit = readInt()
        editTimeLimit = readInt()
        ratingEDecay = readInt()
        stickersRecentLimit = readInt()
        stickersFavedLimit = readInt()
        tmpSessions = readIfMask(1) { readInt() }
        pinnedDialogsCountMax = readInt()
        callReceiveTimeoutMs = readInt()
        callRingTimeoutMs = readInt()
        callConnectTimeoutMs = readInt()
        callPacketTimeoutMs = readInt()
        meUrlPrefix = readString()
        suggestedLangCode = readIfMask(4) { readString() }
        langPackVersion = readIfMask(4) { readInt() }
        disabledFeatures = readTLVector<TLDisabledFeature>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_BOOLEAN
        size += SIZE_INT32
        size += dcOptions.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(tmpSessions, 1) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(meUrlPrefix)
        size += getIntIfMask(suggestedLangCode, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(langPackVersion, 4) { SIZE_INT32 }
        size += disabledFeatures.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLConfig) return false
        if (other === this) return true

        return _flags == other._flags
                && phonecallsEnabled == other.phonecallsEnabled
                && date == other.date
                && expires == other.expires
                && testMode == other.testMode
                && thisDc == other.thisDc
                && dcOptions == other.dcOptions
                && chatSizeMax == other.chatSizeMax
                && megagroupSizeMax == other.megagroupSizeMax
                && forwardedCountMax == other.forwardedCountMax
                && onlineUpdatePeriodMs == other.onlineUpdatePeriodMs
                && offlineBlurTimeoutMs == other.offlineBlurTimeoutMs
                && offlineIdleTimeoutMs == other.offlineIdleTimeoutMs
                && onlineCloudTimeoutMs == other.onlineCloudTimeoutMs
                && notifyCloudDelayMs == other.notifyCloudDelayMs
                && notifyDefaultDelayMs == other.notifyDefaultDelayMs
                && chatBigSize == other.chatBigSize
                && pushChatPeriodMs == other.pushChatPeriodMs
                && pushChatLimit == other.pushChatLimit
                && savedGifsLimit == other.savedGifsLimit
                && editTimeLimit == other.editTimeLimit
                && ratingEDecay == other.ratingEDecay
                && stickersRecentLimit == other.stickersRecentLimit
                && stickersFavedLimit == other.stickersFavedLimit
                && tmpSessions == other.tmpSessions
                && pinnedDialogsCountMax == other.pinnedDialogsCountMax
                && callReceiveTimeoutMs == other.callReceiveTimeoutMs
                && callRingTimeoutMs == other.callRingTimeoutMs
                && callConnectTimeoutMs == other.callConnectTimeoutMs
                && callPacketTimeoutMs == other.callPacketTimeoutMs
                && meUrlPrefix == other.meUrlPrefix
                && suggestedLangCode == other.suggestedLangCode
                && langPackVersion == other.langPackVersion
                && disabledFeatures == other.disabledFeatures
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8df376a4.toInt()
    }
}
