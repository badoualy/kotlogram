package com.github.badoualy.telegram.tl.api

/**
 * userStatusRecently#e26f42f1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserStatusRecently : TLAbsUserStatus() {
    private val _constructor: String = "userStatusRecently#e26f42f1"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserStatusRecently) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe26f42f1.toInt()
    }
}
