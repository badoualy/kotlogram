package com.github.badoualy.telegram.tl.api

/**
 * inputPeerNotifyEventsEmpty#f03064d8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPeerNotifyEventsEmpty : TLAbsInputPeerNotifyEvents() {
    private val _constructor: String = "inputPeerNotifyEventsEmpty#f03064d8"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPeerNotifyEventsEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf03064d8.toInt()
    }
}
