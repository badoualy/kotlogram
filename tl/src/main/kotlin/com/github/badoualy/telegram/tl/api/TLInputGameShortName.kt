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
 * inputGameShortName#c331e80a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputGameShortName() : TLAbsInputGame() {
    var botId: TLAbsInputUser = TLInputUserEmpty()

    var shortName: String = ""

    private val _constructor: String = "inputGameShortName#c331e80a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(botId: TLAbsInputUser, shortName: String) : this() {
        this.botId = botId
        this.shortName = shortName
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(botId)
        writeString(shortName)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        botId = readTLObject<TLAbsInputUser>()
        shortName = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += botId.computeSerializedSize()
        size += computeTLStringSerializedSize(shortName)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputGameShortName) return false
        if (other === this) return true

        return botId == other.botId
                && shortName == other.shortName
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc331e80a.toInt()
    }
}
