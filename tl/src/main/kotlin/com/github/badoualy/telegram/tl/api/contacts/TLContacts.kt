package com.github.badoualy.telegram.tl.api.contacts

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLContact
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
 * contacts.contacts#eae87e42
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLContacts() : TLAbsContacts() {
    var contacts: TLObjectVector<TLContact> = TLObjectVector()

    var savedCount: Int = 0

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "contacts.contacts#eae87e42"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            contacts: TLObjectVector<TLContact>,
            savedCount: Int,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.contacts = contacts
        this.savedCount = savedCount
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(contacts)
        writeInt(savedCount)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        contacts = readTLVector<TLContact>()
        savedCount = readInt()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += contacts.computeSerializedSize()
        size += SIZE_INT32
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLContacts) return false
        if (other === this) return true

        return contacts == other.contacts
                && savedCount == other.savedCount
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xeae87e42.toInt()
    }
}
