package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterPhotoVideoDocuments#d95e73bb
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterPhotoVideoDocuments : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterPhotoVideoDocuments#d95e73bb"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterPhotoVideoDocuments) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd95e73bb.toInt()
    }
}
