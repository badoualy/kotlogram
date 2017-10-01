package com.github.badoualy.telegram.tl.api.auth

/**
 * auth.codeTypeCall#741cd3e3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLCodeTypeCall : TLAbsCodeType() {
    private val _constructor: String = "auth.codeTypeCall#741cd3e3"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLCodeTypeCall) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x741cd3e3.toInt()
    }
}
