package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterContacts#e062db83
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterContacts : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterContacts#e062db83"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterContacts) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe062db83.toInt()
    }
}
