package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * encryptedMessage#ed18c118
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEncryptedMessage() : TLAbsEncryptedMessage() {
    override var randomId: Long = 0L

    override var chatId: Int = 0

    override var date: Int = 0

    override var bytes: TLBytes = TLBytes.EMPTY

    var file: TLAbsEncryptedFile = TLEncryptedFileEmpty()

    private val _constructor: String = "encryptedMessage#ed18c118"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            randomId: Long,
            chatId: Int,
            date: Int,
            bytes: TLBytes,
            file: TLAbsEncryptedFile
    ) : this() {
        this.randomId = randomId
        this.chatId = chatId
        this.date = date
        this.bytes = bytes
        this.file = file
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(randomId)
        writeInt(chatId)
        writeInt(date)
        writeTLBytes(bytes)
        writeTLObject(file)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        randomId = readLong()
        chatId = readInt()
        date = readInt()
        bytes = readTLBytes()
        file = readTLObject<TLAbsEncryptedFile>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(bytes)
        size += file.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEncryptedMessage) return false
        if (other === this) return true

        return randomId == other.randomId
                && chatId == other.chatId
                && date == other.date
                && bytes == other.bytes
                && file == other.file
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xed18c118.toInt()
    }
}
