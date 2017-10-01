package com.github.badoualy.telegram.tl.api

/**
 * inputPeerSelf#7da07ec9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPeerSelf : TLAbsInputPeer() {
    private val _constructor: String = "inputPeerSelf#7da07ec9"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPeerSelf) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7da07ec9.toInt()
    }
}
