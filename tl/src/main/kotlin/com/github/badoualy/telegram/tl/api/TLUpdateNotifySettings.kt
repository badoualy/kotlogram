package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateNotifySettings#bec268ef
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateNotifySettings() : TLAbsUpdate() {
    var peer: TLAbsNotifyPeer = TLNotifyUsers()

    var notifySettings: TLAbsPeerNotifySettings = TLPeerNotifySettingsEmpty()

    private val _constructor: String = "updateNotifySettings#bec268ef"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peer: TLAbsNotifyPeer, notifySettings: TLAbsPeerNotifySettings) : this() {
        this.peer = peer
        this.notifySettings = notifySettings
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLObject(notifySettings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsNotifyPeer>()
        notifySettings = readTLObject<TLAbsPeerNotifySettings>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += notifySettings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateNotifySettings) return false
        if (other === this) return true

        return peer == other.peer
                && notifySettings == other.notifySettings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbec268ef.toInt()
    }
}
