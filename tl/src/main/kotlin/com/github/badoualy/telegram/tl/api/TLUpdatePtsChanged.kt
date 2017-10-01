package com.github.badoualy.telegram.tl.api

/**
 * updatePtsChanged#3354678f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePtsChanged : TLAbsUpdate() {
    private val _constructor: String = "updatePtsChanged#3354678f"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePtsChanged) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3354678f.toInt()
    }
}
