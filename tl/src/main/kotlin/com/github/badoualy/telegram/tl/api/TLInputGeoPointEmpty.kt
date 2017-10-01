package com.github.badoualy.telegram.tl.api

/**
 * inputGeoPointEmpty#e4c123d6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputGeoPointEmpty : TLAbsInputGeoPoint() {
    private val _constructor: String = "inputGeoPointEmpty#e4c123d6"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputGeoPointEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe4c123d6.toInt()
    }
}
