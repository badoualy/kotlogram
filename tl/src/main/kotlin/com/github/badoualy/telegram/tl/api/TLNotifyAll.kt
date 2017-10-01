package com.github.badoualy.telegram.tl.api

/**
 * notifyAll#74d07c60
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLNotifyAll : TLAbsNotifyPeer() {
    private val _constructor: String = "notifyAll#74d07c60"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLNotifyAll) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x74d07c60.toInt()
    }
}
