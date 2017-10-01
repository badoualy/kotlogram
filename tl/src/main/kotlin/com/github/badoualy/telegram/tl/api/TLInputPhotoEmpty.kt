package com.github.badoualy.telegram.tl.api

/**
 * inputPhotoEmpty#1cd7bf0d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPhotoEmpty : TLAbsInputPhoto() {
    private val _constructor: String = "inputPhotoEmpty#1cd7bf0d"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPhotoEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1cd7bf0d.toInt()
    }
}
