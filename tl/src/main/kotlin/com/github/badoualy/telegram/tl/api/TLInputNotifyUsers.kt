package com.github.badoualy.telegram.tl.api

/**
 * inputNotifyUsers#193b4417
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputNotifyUsers : TLAbsInputNotifyPeer() {
    private val _constructor: String = "inputNotifyUsers#193b4417"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputNotifyUsers) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x193b4417.toInt()
    }
}
