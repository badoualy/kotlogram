package com.github.badoualy.telegram.tl.api

/**
 * inputMediaEmpty#9664f57f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaEmpty : TLAbsInputMedia() {
    private val _constructor: String = "inputMediaEmpty#9664f57f"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9664f57f.toInt()
    }
}
