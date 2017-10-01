package com.github.badoualy.telegram.tl.api

/**
 * inputNotifyChats#4a95e84e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputNotifyChats : TLAbsInputNotifyPeer() {
    private val _constructor: String = "inputNotifyChats#4a95e84e"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputNotifyChats) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4a95e84e.toInt()
    }
}
