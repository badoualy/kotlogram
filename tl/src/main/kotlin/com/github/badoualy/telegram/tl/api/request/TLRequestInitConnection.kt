package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestInitConnection<T : TLObject>() : TLMethod<T>() {
    var apiId: Int = 0

    var deviceModel: String = ""

    var systemVersion: String = ""

    var appVersion: String = ""

    var systemLangCode: String = ""

    var langPack: String = ""

    var langCode: String = ""

    var query: TLMethod<T>? = null

    private val _constructor: String = "initConnection#c7481da6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            query: TLMethod<T>?
    ) : this() {
        this.apiId = apiId
        this.deviceModel = deviceModel
        this.systemVersion = systemVersion
        this.appVersion = appVersion
        this.systemLangCode = systemLangCode
        this.langPack = langPack
        this.langCode = langCode
        this.query = query
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): T = query!!.deserializeResponse(tlDeserializer)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(apiId)
        writeString(deviceModel)
        writeString(systemVersion)
        writeString(appVersion)
        writeString(systemLangCode)
        writeString(langPack)
        writeString(langCode)
        writeTLMethod(query!!)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        apiId = readInt()
        deviceModel = readString()
        systemVersion = readString()
        appVersion = readString()
        systemLangCode = readString()
        langPack = readString()
        langCode = readString()
        query = readTLMethod()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(deviceModel)
        size += computeTLStringSerializedSize(systemVersion)
        size += computeTLStringSerializedSize(appVersion)
        size += computeTLStringSerializedSize(systemLangCode)
        size += computeTLStringSerializedSize(langPack)
        size += computeTLStringSerializedSize(langCode)
        size += query!!.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestInitConnection<*>) return false
        if (other === this) return true

        return apiId == other.apiId
                && deviceModel == other.deviceModel
                && systemVersion == other.systemVersion
                && appVersion == other.appVersion
                && systemLangCode == other.systemLangCode
                && langPack == other.langPack
                && langCode == other.langCode
                && query == other.query
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc7481da6.toInt()
    }
}
