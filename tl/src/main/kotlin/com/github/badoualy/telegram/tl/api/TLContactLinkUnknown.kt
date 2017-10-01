package com.github.badoualy.telegram.tl.api

/**
 * contactLinkUnknown#5f4f9247
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLContactLinkUnknown : TLAbsContactLink() {
    private val _constructor: String = "contactLinkUnknown#5f4f9247"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLContactLinkUnknown) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5f4f9247.toInt()
    }
}
