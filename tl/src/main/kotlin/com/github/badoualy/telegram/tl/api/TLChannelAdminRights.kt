package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * channelAdminRights#5d7ceba5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminRights() : TLObject() {
    @Transient
    var changeInfo: Boolean = false

    @Transient
    var postMessages: Boolean = false

    @Transient
    var editMessages: Boolean = false

    @Transient
    var deleteMessages: Boolean = false

    @Transient
    var banUsers: Boolean = false

    @Transient
    var inviteUsers: Boolean = false

    @Transient
    var inviteLink: Boolean = false

    @Transient
    var pinMessages: Boolean = false

    @Transient
    var addAdmins: Boolean = false

    @Transient
    var manageCall: Boolean = false

    private val _constructor: String = "channelAdminRights#5d7ceba5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            changeInfo: Boolean,
            postMessages: Boolean,
            editMessages: Boolean,
            deleteMessages: Boolean,
            banUsers: Boolean,
            inviteUsers: Boolean,
            inviteLink: Boolean,
            pinMessages: Boolean,
            addAdmins: Boolean,
            manageCall: Boolean
    ) : this() {
        this.changeInfo = changeInfo
        this.postMessages = postMessages
        this.editMessages = editMessages
        this.deleteMessages = deleteMessages
        this.banUsers = banUsers
        this.inviteUsers = inviteUsers
        this.inviteLink = inviteLink
        this.pinMessages = pinMessages
        this.addAdmins = addAdmins
        this.manageCall = manageCall
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(changeInfo, 1)
        updateFlags(postMessages, 2)
        updateFlags(editMessages, 4)
        updateFlags(deleteMessages, 8)
        updateFlags(banUsers, 16)
        updateFlags(inviteUsers, 32)
        updateFlags(inviteLink, 64)
        updateFlags(pinMessages, 128)
        updateFlags(addAdmins, 512)
        updateFlags(manageCall, 1024)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        changeInfo = isMask(1)
        postMessages = isMask(2)
        editMessages = isMask(4)
        deleteMessages = isMask(8)
        banUsers = isMask(16)
        inviteUsers = isMask(32)
        inviteLink = isMask(64)
        pinMessages = isMask(128)
        addAdmins = isMask(512)
        manageCall = isMask(1024)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminRights) return false
        if (other === this) return true

        return _flags == other._flags
                && changeInfo == other.changeInfo
                && postMessages == other.postMessages
                && editMessages == other.editMessages
                && deleteMessages == other.deleteMessages
                && banUsers == other.banUsers
                && inviteUsers == other.inviteUsers
                && inviteLink == other.inviteLink
                && pinMessages == other.pinMessages
                && addAdmins == other.addAdmins
                && manageCall == other.manageCall
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5d7ceba5.toInt()
    }
}
