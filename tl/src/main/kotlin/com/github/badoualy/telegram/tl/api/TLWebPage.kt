package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * webPage#5f07b4bc
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWebPage() : TLAbsWebPage() {
    var id: Long = 0L

    var url: String = ""

    var displayUrl: String = ""

    var hash: Int = 0

    var type: String? = null

    var siteName: String? = null

    var title: String? = null

    var description: String? = null

    var photo: TLAbsPhoto? = null

    var embedUrl: String? = null

    var embedType: String? = null

    var embedWidth: Int? = null

    var embedHeight: Int? = null

    var duration: Int? = null

    var author: String? = null

    var document: TLAbsDocument? = null

    var cachedPage: TLAbsPage? = null

    private val _constructor: String = "webPage#5f07b4bc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            url: String,
            displayUrl: String,
            hash: Int,
            type: String?,
            siteName: String?,
            title: String?,
            description: String?,
            photo: TLAbsPhoto?,
            embedUrl: String?,
            embedType: String?,
            embedWidth: Int?,
            embedHeight: Int?,
            duration: Int?,
            author: String?,
            document: TLAbsDocument?,
            cachedPage: TLAbsPage?
    ) : this() {
        this.id = id
        this.url = url
        this.displayUrl = displayUrl
        this.hash = hash
        this.type = type
        this.siteName = siteName
        this.title = title
        this.description = description
        this.photo = photo
        this.embedUrl = embedUrl
        this.embedType = embedType
        this.embedWidth = embedWidth
        this.embedHeight = embedHeight
        this.duration = duration
        this.author = author
        this.document = document
        this.cachedPage = cachedPage
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(type, 1)
        updateFlags(siteName, 2)
        updateFlags(title, 4)
        updateFlags(description, 8)
        updateFlags(photo, 16)
        updateFlags(embedUrl, 32)
        updateFlags(embedType, 32)
        updateFlags(embedWidth, 64)
        updateFlags(embedHeight, 64)
        updateFlags(duration, 128)
        updateFlags(author, 256)
        updateFlags(document, 512)
        updateFlags(cachedPage, 1024)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeString(url)
        writeString(displayUrl)
        writeInt(hash)
        doIfMask(type, 1) { writeString(it) }
        doIfMask(siteName, 2) { writeString(it) }
        doIfMask(title, 4) { writeString(it) }
        doIfMask(description, 8) { writeString(it) }
        doIfMask(photo, 16) { writeTLObject(it) }
        doIfMask(embedUrl, 32) { writeString(it) }
        doIfMask(embedType, 32) { writeString(it) }
        doIfMask(embedWidth, 64) { writeInt(it) }
        doIfMask(embedHeight, 64) { writeInt(it) }
        doIfMask(duration, 128) { writeInt(it) }
        doIfMask(author, 256) { writeString(it) }
        doIfMask(document, 512) { writeTLObject(it) }
        doIfMask(cachedPage, 1024) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readLong()
        url = readString()
        displayUrl = readString()
        hash = readInt()
        type = readIfMask(1) { readString() }
        siteName = readIfMask(2) { readString() }
        title = readIfMask(4) { readString() }
        description = readIfMask(8) { readString() }
        photo = readIfMask(16) { readTLObject<TLAbsPhoto>() }
        embedUrl = readIfMask(32) { readString() }
        embedType = readIfMask(32) { readString() }
        embedWidth = readIfMask(64) { readInt() }
        embedHeight = readIfMask(64) { readInt() }
        duration = readIfMask(128) { readInt() }
        author = readIfMask(256) { readString() }
        document = readIfMask(512) { readTLObject<TLAbsDocument>() }
        cachedPage = readIfMask(1024) { readTLObject<TLAbsPage>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(url)
        size += computeTLStringSerializedSize(displayUrl)
        size += SIZE_INT32
        size += getIntIfMask(type, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(siteName, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(title, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(description, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(photo, 16) { it.computeSerializedSize() }
        size += getIntIfMask(embedUrl, 32) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(embedType, 32) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(embedWidth, 64) { SIZE_INT32 }
        size += getIntIfMask(embedHeight, 64) { SIZE_INT32 }
        size += getIntIfMask(duration, 128) { SIZE_INT32 }
        size += getIntIfMask(author, 256) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(document, 512) { it.computeSerializedSize() }
        size += getIntIfMask(cachedPage, 1024) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWebPage) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && url == other.url
                && displayUrl == other.displayUrl
                && hash == other.hash
                && type == other.type
                && siteName == other.siteName
                && title == other.title
                && description == other.description
                && photo == other.photo
                && embedUrl == other.embedUrl
                && embedType == other.embedType
                && embedWidth == other.embedWidth
                && embedHeight == other.embedHeight
                && duration == other.duration
                && author == other.author
                && document == other.document
                && cachedPage == other.cachedPage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5f07b4bc.toInt()
    }
}
