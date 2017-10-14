package com.github.badoualy.telegram.tl.api.contacts

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsContactLink
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLContactLinkHasPhone
import com.github.badoualy.telegram.tl.api.TLUserEmpty
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * contacts.link#3ace484c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLLink() : TLObject() {
    var myLink: TLAbsContactLink = TLContactLinkHasPhone()

    var foreignLink: TLAbsContactLink = TLContactLinkHasPhone()

    var user: TLAbsUser = TLUserEmpty()

    private val _constructor: String = "contacts.link#3ace484c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            myLink: TLAbsContactLink,
            foreignLink: TLAbsContactLink,
            user: TLAbsUser
    ) : this() {
        this.myLink = myLink
        this.foreignLink = foreignLink
        this.user = user
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(myLink)
        writeTLObject(foreignLink)
        writeTLObject(user)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        myLink = readTLObject<TLAbsContactLink>()
        foreignLink = readTLObject<TLAbsContactLink>()
        user = readTLObject<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += myLink.computeSerializedSize()
        size += foreignLink.computeSerializedSize()
        size += user.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLLink) return false
        if (other === this) return true

        return myLink == other.myLink
                && foreignLink == other.foreignLink
                && user == other.user
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3ace484c.toInt()
    }
}
