package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.account.TLTakeout
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountInitTakeoutSession() : TLMethod<TLTakeout>() {
    @Transient
    var contacts: Boolean = false

    @Transient
    var messageUsers: Boolean = false

    @Transient
    var messageChats: Boolean = false

    @Transient
    var messageMegagroups: Boolean = false

    @Transient
    var messageChannels: Boolean = false

    @Transient
    var files: Boolean = false

    var fileMaxSize: Int? = null

    private val _constructor: String = "account.initTakeoutSession#f05b4804"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            contacts: Boolean,
            messageUsers: Boolean,
            messageChats: Boolean,
            messageMegagroups: Boolean,
            messageChannels: Boolean,
            files: Boolean,
            fileMaxSize: Int?
    ) : this() {
        this.contacts = contacts
        this.messageUsers = messageUsers
        this.messageChats = messageChats
        this.messageMegagroups = messageMegagroups
        this.messageChannels = messageChannels
        this.files = files
        this.fileMaxSize = fileMaxSize
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLTakeout = tlDeserializer.readTLObject(TLTakeout::class, TLTakeout.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(contacts, 1)
        updateFlags(messageUsers, 2)
        updateFlags(messageChats, 4)
        updateFlags(messageMegagroups, 8)
        updateFlags(messageChannels, 16)
        updateFlags(files, 32)
        updateFlags(fileMaxSize, 32)

        // Following parameters might be forced to true by another field that updated the flags
        files = isMask(32)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(fileMaxSize, 32) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        contacts = isMask(1)
        messageUsers = isMask(2)
        messageChats = isMask(4)
        messageMegagroups = isMask(8)
        messageChannels = isMask(16)
        files = isMask(32)
        fileMaxSize = readIfMask(32) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(fileMaxSize, 32) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountInitTakeoutSession) return false
        if (other === this) return true

        return _flags == other._flags
                && contacts == other.contacts
                && messageUsers == other.messageUsers
                && messageChats == other.messageChats
                && messageMegagroups == other.messageMegagroups
                && messageChannels == other.messageChannels
                && files == other.files
                && fileMaxSize == other.fileMaxSize
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf05b4804.toInt()
    }
}
