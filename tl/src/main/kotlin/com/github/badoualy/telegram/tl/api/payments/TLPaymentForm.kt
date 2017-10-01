package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * payments.paymentForm#3f56aea3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPaymentForm() : TLObject() {
    @Transient
    var canSaveCredentials: Boolean = false

    @Transient
    var passwordMissing: Boolean = false

    var botId: Int = 0

    var invoice: TLInvoice = TLInvoice()

    var providerId: Int = 0

    var url: String = ""

    var nativeProvider: String? = null

    var nativeParams: TLDataJSON? = null

    var savedInfo: TLPaymentRequestedInfo? = null

    var savedCredentials: TLPaymentSavedCredentialsCard? = null

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "payments.paymentForm#3f56aea3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canSaveCredentials: Boolean,
            passwordMissing: Boolean,
            botId: Int,
            invoice: TLInvoice,
            providerId: Int,
            url: String,
            nativeProvider: String?,
            nativeParams: TLDataJSON?,
            savedInfo: TLPaymentRequestedInfo?,
            savedCredentials: TLPaymentSavedCredentialsCard?,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.canSaveCredentials = canSaveCredentials
        this.passwordMissing = passwordMissing
        this.botId = botId
        this.invoice = invoice
        this.providerId = providerId
        this.url = url
        this.nativeProvider = nativeProvider
        this.nativeParams = nativeParams
        this.savedInfo = savedInfo
        this.savedCredentials = savedCredentials
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(canSaveCredentials, 4)
        updateFlags(passwordMissing, 8)
        updateFlags(nativeProvider, 16)
        updateFlags(nativeParams, 16)
        updateFlags(savedInfo, 1)
        updateFlags(savedCredentials, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(botId)
        writeTLObject(invoice)
        writeInt(providerId)
        writeString(url)
        doIfMask(nativeProvider, 16) { writeString(it) }
        doIfMask(nativeParams, 16) { writeTLObject(it) }
        doIfMask(savedInfo, 1) { writeTLObject(it) }
        doIfMask(savedCredentials, 2) { writeTLObject(it) }
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canSaveCredentials = isMask(4)
        passwordMissing = isMask(8)
        botId = readInt()
        invoice = readTLObject<TLInvoice>(TLInvoice::class, TLInvoice.CONSTRUCTOR_ID)
        providerId = readInt()
        url = readString()
        nativeProvider = readIfMask(16) { readString() }
        nativeParams = readIfMask(16) { readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID) }
        savedInfo = readIfMask(1) { readTLObject<TLPaymentRequestedInfo>(TLPaymentRequestedInfo::class, TLPaymentRequestedInfo.CONSTRUCTOR_ID) }
        savedCredentials = readIfMask(2) { readTLObject<TLPaymentSavedCredentialsCard>(TLPaymentSavedCredentialsCard::class, TLPaymentSavedCredentialsCard.CONSTRUCTOR_ID) }
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += invoice.computeSerializedSize()
        size += SIZE_INT32
        size += computeTLStringSerializedSize(url)
        size += getIntIfMask(nativeProvider, 16) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(nativeParams, 16) { it.computeSerializedSize() }
        size += getIntIfMask(savedInfo, 1) { it.computeSerializedSize() }
        size += getIntIfMask(savedCredentials, 2) { it.computeSerializedSize() }
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPaymentForm) return false
        if (other === this) return true

        return _flags == other._flags
                && canSaveCredentials == other.canSaveCredentials
                && passwordMissing == other.passwordMissing
                && botId == other.botId
                && invoice == other.invoice
                && providerId == other.providerId
                && url == other.url
                && nativeProvider == other.nativeProvider
                && nativeParams == other.nativeParams
                && savedInfo == other.savedInfo
                && savedCredentials == other.savedCredentials
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3f56aea3.toInt()
    }
}
