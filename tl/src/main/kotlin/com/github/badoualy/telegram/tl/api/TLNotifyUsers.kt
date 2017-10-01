package com.github.badoualy.telegram.tl.api

/**
 * notifyUsers#b4c83b4c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLNotifyUsers : TLAbsNotifyPeer() {
    private val _constructor: String = "notifyUsers#b4c83b4c"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLNotifyUsers) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb4c83b4c.toInt()
    }
}
