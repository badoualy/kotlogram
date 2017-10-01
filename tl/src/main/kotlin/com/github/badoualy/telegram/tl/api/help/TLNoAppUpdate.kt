package com.github.badoualy.telegram.tl.api.help

/**
 * help.noAppUpdate#c45a6536
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLNoAppUpdate : TLAbsAppUpdate() {
    private val _constructor: String = "help.noAppUpdate#c45a6536"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLNoAppUpdate) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc45a6536.toInt()
    }
}
