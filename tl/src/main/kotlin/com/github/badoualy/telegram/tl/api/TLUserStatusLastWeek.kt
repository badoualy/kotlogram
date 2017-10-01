package com.github.badoualy.telegram.tl.api

/**
 * userStatusLastWeek#7bf09fc
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserStatusLastWeek : TLAbsUserStatus() {
    private val _constructor: String = "userStatusLastWeek#7bf09fc"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserStatusLastWeek) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7bf09fc.toInt()
    }
}
