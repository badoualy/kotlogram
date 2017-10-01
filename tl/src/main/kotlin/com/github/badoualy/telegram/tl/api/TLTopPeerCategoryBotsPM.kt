package com.github.badoualy.telegram.tl.api

/**
 * topPeerCategoryBotsPM#ab661b5b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTopPeerCategoryBotsPM : TLAbsTopPeerCategory() {
    private val _constructor: String = "topPeerCategoryBotsPM#ab661b5b"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTopPeerCategoryBotsPM) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xab661b5b.toInt()
    }
}
