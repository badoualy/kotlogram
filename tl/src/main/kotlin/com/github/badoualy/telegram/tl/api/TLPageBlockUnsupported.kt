package com.github.badoualy.telegram.tl.api

/**
 * pageBlockUnsupported#13567e8a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockUnsupported : TLAbsPageBlock() {
    private val _constructor: String = "pageBlockUnsupported#13567e8a"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockUnsupported) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x13567e8a.toInt()
    }
}
