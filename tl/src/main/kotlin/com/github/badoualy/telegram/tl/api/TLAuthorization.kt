package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * authorization#7bf2e6f6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAuthorization() : TLObject() {
    var hash: Long = 0L

    var flags: Int = 0

    var deviceModel: String = ""

    var platform: String = ""

    var systemVersion: String = ""

    var apiId: Int = 0

    var appName: String = ""

    var appVersion: String = ""

    var dateCreated: Int = 0

    var dateActive: Int = 0

    var ip: String = ""

    var country: String = ""

    var region: String = ""

    private val _constructor: String = "authorization#7bf2e6f6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hash: Long,
            flags: Int,
            deviceModel: String,
            platform: String,
            systemVersion: String,
            apiId: Int,
            appName: String,
            appVersion: String,
            dateCreated: Int,
            dateActive: Int,
            ip: String,
            country: String,
            region: String
    ) : this() {
        this.hash = hash
        this.flags = flags
        this.deviceModel = deviceModel
        this.platform = platform
        this.systemVersion = systemVersion
        this.apiId = apiId
        this.appName = appName
        this.appVersion = appVersion
        this.dateCreated = dateCreated
        this.dateActive = dateActive
        this.ip = ip
        this.country = country
        this.region = region
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(hash)
        writeInt(flags)
        writeString(deviceModel)
        writeString(platform)
        writeString(systemVersion)
        writeInt(apiId)
        writeString(appName)
        writeString(appVersion)
        writeInt(dateCreated)
        writeInt(dateActive)
        writeString(ip)
        writeString(country)
        writeString(region)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readLong()
        flags = readInt()
        deviceModel = readString()
        platform = readString()
        systemVersion = readString()
        apiId = readInt()
        appName = readString()
        appVersion = readString()
        dateCreated = readInt()
        dateActive = readInt()
        ip = readString()
        country = readString()
        region = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(deviceModel)
        size += computeTLStringSerializedSize(platform)
        size += computeTLStringSerializedSize(systemVersion)
        size += SIZE_INT32
        size += computeTLStringSerializedSize(appName)
        size += computeTLStringSerializedSize(appVersion)
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(ip)
        size += computeTLStringSerializedSize(country)
        size += computeTLStringSerializedSize(region)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAuthorization) return false
        if (other === this) return true

        return hash == other.hash
                && flags == other.flags
                && deviceModel == other.deviceModel
                && platform == other.platform
                && systemVersion == other.systemVersion
                && apiId == other.apiId
                && appName == other.appName
                && appVersion == other.appVersion
                && dateCreated == other.dateCreated
                && dateActive == other.dateActive
                && ip == other.ip
                && country == other.country
                && region == other.region
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7bf2e6f6.toInt()
    }
}
