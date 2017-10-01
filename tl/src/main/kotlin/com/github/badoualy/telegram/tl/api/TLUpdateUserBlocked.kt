package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateUserBlocked#80ece81a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateUserBlocked() : TLAbsUpdate() {
    var userId: Int = 0

    var blocked: Boolean = false

    private val _constructor: String = "updateUserBlocked#80ece81a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(userId: Int, blocked: Boolean) : this() {
        this.userId = userId
        this.blocked = blocked
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(userId)
        writeBoolean(blocked)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readInt()
        blocked = readBoolean()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_BOOLEAN
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateUserBlocked) return false
        if (other === this) return true

        return userId == other.userId
                && blocked == other.blocked
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x80ece81a.toInt()
    }
}
