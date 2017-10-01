package com.github.badoualy.telegram.tl.api.auth

/**
 * auth.codeTypeSms#72a3158c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLCodeTypeSms : TLAbsCodeType() {
    private val _constructor: String = "auth.codeTypeSms#72a3158c"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLCodeTypeSms) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x72a3158c.toInt()
    }
}
