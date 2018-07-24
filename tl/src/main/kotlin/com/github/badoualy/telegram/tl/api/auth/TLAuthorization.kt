package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLUserEmpty
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * auth.authorization#cd050916
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAuthorization() : TLObject() {
    var tmpSessions: Int? = null

    var user: TLAbsUser = TLUserEmpty()

    private val _constructor: String = "auth.authorization#cd050916"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(tmpSessions: Int?, user: TLAbsUser) : this() {
        this.tmpSessions = tmpSessions
        this.user = user
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(tmpSessions, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(tmpSessions, 1) { writeInt(it) }
        writeTLObject(user)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        tmpSessions = readIfMask(1) { readInt() }
        user = readTLObject<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(tmpSessions, 1) { SIZE_INT32 }
        size += user.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAuthorization) return false
        if (other === this) return true

        return _flags == other._flags
                && tmpSessions == other.tmpSessions
                && user == other.user
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcd050916.toInt()
    }
}
