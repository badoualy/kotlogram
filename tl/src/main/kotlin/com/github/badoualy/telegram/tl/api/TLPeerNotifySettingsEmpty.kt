package com.github.badoualy.telegram.tl.api

/**
 * peerNotifySettingsEmpty#70a68512
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerNotifySettingsEmpty : TLAbsPeerNotifySettings() {
    private val _constructor: String = "peerNotifySettingsEmpty#70a68512"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerNotifySettingsEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x70a68512.toInt()
    }
}
