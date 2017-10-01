package com.github.badoualy.telegram.tl.api

/**
 * inputUserEmpty#b98886cf
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputUserEmpty : TLAbsInputUser() {
    private val _constructor: String = "inputUserEmpty#b98886cf"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputUserEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb98886cf.toInt()
    }
}
