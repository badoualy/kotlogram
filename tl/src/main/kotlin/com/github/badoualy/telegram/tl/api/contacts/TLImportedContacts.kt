package com.github.badoualy.telegram.tl.api.contacts

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLImportedContact
import com.github.badoualy.telegram.tl.api.TLPopularContact
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObject
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
 * contacts.importedContacts#77d01c3b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLImportedContacts() : TLObject() {
    var imported: TLObjectVector<TLImportedContact> = TLObjectVector()

    var popularInvites: TLObjectVector<TLPopularContact> = TLObjectVector()

    var retryContacts: TLLongVector = TLLongVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "contacts.importedContacts#77d01c3b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            imported: TLObjectVector<TLImportedContact>,
            popularInvites: TLObjectVector<TLPopularContact>,
            retryContacts: TLLongVector,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.imported = imported
        this.popularInvites = popularInvites
        this.retryContacts = retryContacts
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(imported)
        writeTLVector(popularInvites)
        writeTLVector(retryContacts)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        imported = readTLVector<TLImportedContact>()
        popularInvites = readTLVector<TLPopularContact>()
        retryContacts = readTLLongVector()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += imported.computeSerializedSize()
        size += popularInvites.computeSerializedSize()
        size += retryContacts.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLImportedContacts) return false
        if (other === this) return true

        return imported == other.imported
                && popularInvites == other.popularInvites
                && retryContacts == other.retryContacts
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x77d01c3b.toInt()
    }
}
