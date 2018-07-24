package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile
import com.github.badoualy.telegram.tl.api.TLEncryptedFileEmpty
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * messages.sentEncryptedFile#9493ff32
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSentEncryptedFile() : TLAbsSentEncryptedMessage() {
    override var date: Int = 0

    var file: TLAbsEncryptedFile = TLEncryptedFileEmpty()

    private val _constructor: String = "messages.sentEncryptedFile#9493ff32"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(date: Int, file: TLAbsEncryptedFile) : this() {
        this.date = date
        this.file = file
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(date)
        writeTLObject(file)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        date = readInt()
        file = readTLObject<TLAbsEncryptedFile>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += file.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSentEncryptedFile) return false
        if (other === this) return true

        return date == other.date
                && file == other.file
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9493ff32.toInt()
    }
}
