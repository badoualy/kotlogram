package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountUpdatePasswordSettings() : TLMethod<TLBool>() {
    var currentPasswordHash: TLBytes = TLBytes.EMPTY

    var newSettings: TLPasswordInputSettings = TLPasswordInputSettings()

    private val _constructor: String = "account.updatePasswordSettings#fa7c4b86"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(currentPasswordHash: TLBytes, newSettings: TLPasswordInputSettings) : this() {
        this.currentPasswordHash = currentPasswordHash
        this.newSettings = newSettings
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLBytes(currentPasswordHash)
        writeTLObject(newSettings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        currentPasswordHash = readTLBytes()
        newSettings = readTLObject<TLPasswordInputSettings>(TLPasswordInputSettings::class, TLPasswordInputSettings.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLBytesSerializedSize(currentPasswordHash)
        size += newSettings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUpdatePasswordSettings) return false
        if (other === this) return true

        return currentPasswordHash == other.currentPasswordHash
                && newSettings == other.newSettings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfa7c4b86.toInt()
    }
}
