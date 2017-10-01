package com.github.badoualy.telegram.tl.api

/**
 * contactLinkNone#feedd3ad
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLContactLinkNone : TLAbsContactLink() {
    private val _constructor: String = "contactLinkNone#feedd3ad"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLContactLinkNone) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfeedd3ad.toInt()
    }
}
