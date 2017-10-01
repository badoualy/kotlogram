package com.github.badoualy.telegram.tl.api

/**
 * contactLinkHasPhone#268f3f59
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLContactLinkHasPhone : TLAbsContactLink() {
    private val _constructor: String = "contactLinkHasPhone#268f3f59"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLContactLinkHasPhone) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x268f3f59.toInt()
    }
}
