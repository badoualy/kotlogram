package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesCreateChat() : TLMethod<TLAbsUpdates>() {
    var users: TLObjectVector<TLAbsInputUser> = TLObjectVector()

    var title: String = ""

    private val _constructor: String = "messages.createChat#9cb126e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(users: TLObjectVector<TLAbsInputUser>, title: String) : this() {
        this.users = users
        this.title = title
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(users)
        writeString(title)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        users = readTLVector<TLAbsInputUser>()
        title = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += users.computeSerializedSize()
        size += computeTLStringSerializedSize(title)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesCreateChat) return false
        if (other === this) return true

        return users == other.users
                && title == other.title
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9cb126e.toInt()
    }
}
