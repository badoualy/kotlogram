package com.github.badoualy.telegram.tl.api

/**
 * userProfilePhotoEmpty#4f11bae1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserProfilePhotoEmpty : TLAbsUserProfilePhoto() {
    private val _constructor: String = "userProfilePhotoEmpty#4f11bae1"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserProfilePhotoEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4f11bae1.toInt()
    }
}
