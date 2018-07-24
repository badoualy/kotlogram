package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer
import com.github.badoualy.telegram.tl.api.TLInputNotifyUsers
import com.github.badoualy.telegram.tl.api.TLInputPeerNotifySettings
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountUpdateNotifySettings() : TLMethod<TLBool>() {
    var peer: TLAbsInputNotifyPeer = TLInputNotifyUsers()

    var settings: TLInputPeerNotifySettings = TLInputPeerNotifySettings()

    private val _constructor: String = "account.updateNotifySettings#84be5b93"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings) : this() {
        this.peer = peer
        this.settings = settings
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLObject(settings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputNotifyPeer>()
        settings = readTLObject<TLInputPeerNotifySettings>(TLInputPeerNotifySettings::class, TLInputPeerNotifySettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += settings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUpdateNotifySettings) return false
        if (other === this) return true

        return peer == other.peer
                && settings == other.settings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x84be5b93.toInt()
    }
}
