package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputMediaInvoice#92153685
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaInvoice() : TLAbsInputMedia() {
    var title: String = ""

    var description: String = ""

    var photo: TLInputWebDocument? = null

    var invoice: TLInvoice = TLInvoice()

    var payload: TLBytes = TLBytes.EMPTY

    var provider: String = ""

    var startParam: String = ""

    private val _constructor: String = "inputMediaInvoice#92153685"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            title: String,
            description: String,
            photo: TLInputWebDocument?,
            invoice: TLInvoice,
            payload: TLBytes,
            provider: String,
            startParam: String
    ) : this() {
        this.title = title
        this.description = description
        this.photo = photo
        this.invoice = invoice
        this.payload = payload
        this.provider = provider
        this.startParam = startParam
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(photo, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        writeString(description)
        doIfMask(photo, 1) { writeTLObject(it) }
        writeTLObject(invoice)
        writeTLBytes(payload)
        writeString(provider)
        writeString(startParam)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        title = readString()
        description = readString()
        photo = readIfMask(1) { readTLObject<TLInputWebDocument>(TLInputWebDocument::class, TLInputWebDocument.CONSTRUCTOR_ID) }
        invoice = readTLObject<TLInvoice>(TLInvoice::class, TLInvoice.CONSTRUCTOR_ID)
        payload = readTLBytes()
        provider = readString()
        startParam = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += getIntIfMask(photo, 1) { it.computeSerializedSize() }
        size += invoice.computeSerializedSize()
        size += computeTLBytesSerializedSize(payload)
        size += computeTLStringSerializedSize(provider)
        size += computeTLStringSerializedSize(startParam)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaInvoice) return false
        if (other === this) return true

        return _flags == other._flags
                && title == other.title
                && description == other.description
                && photo == other.photo
                && invoice == other.invoice
                && payload == other.payload
                && provider == other.provider
                && startParam == other.startParam
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x92153685.toInt()
    }
}
