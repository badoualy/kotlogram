package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterEmpty#57e2f66c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterEmpty : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterEmpty#57e2f66c"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x57e2f66c.toInt()
    }
}
