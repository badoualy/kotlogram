package com.github.badoualy.telegram.tl.api

/**
 * updateConfig#a229dd06
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateConfig : TLAbsUpdate() {
    private val _constructor: String = "updateConfig#a229dd06"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateConfig) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa229dd06.toInt()
    }
}
