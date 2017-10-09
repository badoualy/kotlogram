package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestHelpGetAppChangelog() : TLMethod<TLAbsUpdates>() {
    var prevAppVersion: String = ""

    private val _constructor: String = "help.getAppChangelog#9010ef6f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(prevAppVersion: String) : this() {
        this.prevAppVersion = prevAppVersion
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(prevAppVersion)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        prevAppVersion = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(prevAppVersion)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestHelpGetAppChangelog) return false
        if (other === this) return true

        return prevAppVersion == other.prevAppVersion
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9010ef6f.toInt()
    }
}
