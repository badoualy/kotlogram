package com.github.badoualy.telegram.tl.api

/**
 * textEmpty#dc3d824f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTextEmpty : TLAbsRichText() {
    private val _constructor: String = "textEmpty#dc3d824f"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTextEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdc3d824f.toInt()
    }
}
