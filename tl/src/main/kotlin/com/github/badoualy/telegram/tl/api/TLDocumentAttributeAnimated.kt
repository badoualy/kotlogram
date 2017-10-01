package com.github.badoualy.telegram.tl.api

/**
 * documentAttributeAnimated#11b58939
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDocumentAttributeAnimated : TLAbsDocumentAttribute() {
    private val _constructor: String = "documentAttributeAnimated#11b58939"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDocumentAttributeAnimated) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x11b58939.toInt()
    }
}
