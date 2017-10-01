package com.github.badoualy.telegram.tl.api

/**
 * notifyChats#c007cec3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLNotifyChats : TLAbsNotifyPeer() {
    private val _constructor: String = "notifyChats#c007cec3"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLNotifyChats) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc007cec3.toInt()
    }
}
