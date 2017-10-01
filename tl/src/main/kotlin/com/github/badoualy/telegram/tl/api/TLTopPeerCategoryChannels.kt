package com.github.badoualy.telegram.tl.api

/**
 * topPeerCategoryChannels#161d9628
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTopPeerCategoryChannels : TLAbsTopPeerCategory() {
    private val _constructor: String = "topPeerCategoryChannels#161d9628"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTopPeerCategoryChannels) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x161d9628.toInt()
    }
}
