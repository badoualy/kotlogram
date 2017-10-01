package com.github.badoualy.telegram.tl.api

/**
 * inputUserSelf#f7c1b13f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputUserSelf : TLAbsInputUser() {
    private val _constructor: String = "inputUserSelf#f7c1b13f"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputUserSelf) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf7c1b13f.toInt()
    }
}
