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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * webAuthorization#cac943f2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWebAuthorization() : TLObject() {
    var hash: Long = 0L

    var botId: Int = 0

    var domain: String = ""

    var browser: String = ""

    var platform: String = ""

    var dateCreated: Int = 0

    var dateActive: Int = 0

    var ip: String = ""

    var region: String = ""

    private val _constructor: String = "webAuthorization#cac943f2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hash: Long,
            botId: Int,
            domain: String,
            browser: String,
            platform: String,
            dateCreated: Int,
            dateActive: Int,
            ip: String,
            region: String
    ) : this() {
        this.hash = hash
        this.botId = botId
        this.domain = domain
        this.browser = browser
        this.platform = platform
        this.dateCreated = dateCreated
        this.dateActive = dateActive
        this.ip = ip
        this.region = region
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(hash)
        writeInt(botId)
        writeString(domain)
        writeString(browser)
        writeString(platform)
        writeInt(dateCreated)
        writeInt(dateActive)
        writeString(ip)
        writeString(region)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readLong()
        botId = readInt()
        domain = readString()
        browser = readString()
        platform = readString()
        dateCreated = readInt()
        dateActive = readInt()
        ip = readString()
        region = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(domain)
        size += computeTLStringSerializedSize(browser)
        size += computeTLStringSerializedSize(platform)
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(ip)
        size += computeTLStringSerializedSize(region)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWebAuthorization) return false
        if (other === this) return true

        return hash == other.hash
                && botId == other.botId
                && domain == other.domain
                && browser == other.browser
                && platform == other.platform
                && dateCreated == other.dateCreated
                && dateActive == other.dateActive
                && ip == other.ip
                && region == other.region
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcac943f2.toInt()
    }
}
