package com.github.badoualy.telegram.tl.api

/**
 * topPeerCategoryPhoneCalls#1e76a78c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTopPeerCategoryPhoneCalls : TLAbsTopPeerCategory() {
    private val _constructor: String = "topPeerCategoryPhoneCalls#1e76a78c"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTopPeerCategoryPhoneCalls) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1e76a78c.toInt()
    }
}
