package com.github.badoualy.telegram.tl.api

/**
 * peerNotifyEventsEmpty#add53cb3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerNotifyEventsEmpty : TLAbsPeerNotifyEvents() {
    private val _constructor: String = "peerNotifyEventsEmpty#add53cb3"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerNotifyEventsEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xadd53cb3.toInt()
    }
}
