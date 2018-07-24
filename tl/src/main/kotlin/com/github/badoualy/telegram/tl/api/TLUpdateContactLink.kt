package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * updateContactLink#9d2e67c5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateContactLink() : TLAbsUpdate() {
    var userId: Int = 0

    var myLink: TLAbsContactLink = TLContactLinkHasPhone()

    var foreignLink: TLAbsContactLink = TLContactLinkHasPhone()

    private val _constructor: String = "updateContactLink#9d2e67c5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Int,
            myLink: TLAbsContactLink,
            foreignLink: TLAbsContactLink
    ) : this() {
        this.userId = userId
        this.myLink = myLink
        this.foreignLink = foreignLink
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(userId)
        writeTLObject(myLink)
        writeTLObject(foreignLink)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readInt()
        myLink = readTLObject<TLAbsContactLink>()
        foreignLink = readTLObject<TLAbsContactLink>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += myLink.computeSerializedSize()
        size += foreignLink.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateContactLink) return false
        if (other === this) return true

        return userId == other.userId
                && myLink == other.myLink
                && foreignLink == other.foreignLink
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9d2e67c5.toInt()
    }
}
