package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterRoundVideo#b549da53
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterRoundVideo : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterRoundVideo#b549da53"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterRoundVideo) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb549da53.toInt()
    }
}
