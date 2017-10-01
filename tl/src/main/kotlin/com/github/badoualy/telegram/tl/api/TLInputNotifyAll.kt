package com.github.badoualy.telegram.tl.api

/**
 * inputNotifyAll#a429b886
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputNotifyAll : TLAbsInputNotifyPeer() {
    private val _constructor: String = "inputNotifyAll#a429b886"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputNotifyAll) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa429b886.toInt()
    }
}
