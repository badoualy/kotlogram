package com.github.badoualy.telegram.tl.api

/**
 * userStatusEmpty#9d05049
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserStatusEmpty : TLAbsUserStatus() {
    private val _constructor: String = "userStatusEmpty#9d05049"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserStatusEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9d05049.toInt()
    }
}
