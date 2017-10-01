package com.github.badoualy.telegram.tl.api

/**
 * peerNotifyEventsAll#6d1ded88
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerNotifyEventsAll : TLAbsPeerNotifyEvents() {
    private val _constructor: String = "peerNotifyEventsAll#6d1ded88"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerNotifyEventsAll) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6d1ded88.toInt()
    }
}
