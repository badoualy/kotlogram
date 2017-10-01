package com.github.badoualy.telegram.tl.api

/**
 * userStatusLastMonth#77ebc742
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserStatusLastMonth : TLAbsUserStatus() {
    private val _constructor: String = "userStatusLastMonth#77ebc742"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserStatusLastMonth) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x77ebc742.toInt()
    }
}
