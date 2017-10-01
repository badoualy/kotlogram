package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputChatUploadedPhoto#927c55b4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputChatUploadedPhoto() : TLAbsInputChatPhoto() {
    var file: TLAbsInputFile = TLInputFileBig()

    private val _constructor: String = "inputChatUploadedPhoto#927c55b4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(file: TLAbsInputFile) : this() {
        this.file = file
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(file)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        file = readTLObject<TLAbsInputFile>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += file.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputChatUploadedPhoto) return false
        if (other === this) return true

        return file == other.file
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x927c55b4.toInt()
    }
}
