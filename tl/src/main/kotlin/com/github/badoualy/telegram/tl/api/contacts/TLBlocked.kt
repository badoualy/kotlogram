package com.github.badoualy.telegram.tl.api.contacts

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLContactBlocked
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * contacts.blocked#1c138d15
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBlocked() : TLAbsBlocked() {
    override var blocked: TLObjectVector<TLContactBlocked> = TLObjectVector()

    override var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "contacts.blocked#1c138d15"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(blocked: TLObjectVector<TLContactBlocked>, users: TLObjectVector<TLAbsUser>) : this() {
        this.blocked = blocked
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(blocked)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        blocked = readTLVector<TLContactBlocked>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += blocked.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBlocked) return false
        if (other === this) return true

        return blocked == other.blocked
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1c138d15.toInt()
    }
}
