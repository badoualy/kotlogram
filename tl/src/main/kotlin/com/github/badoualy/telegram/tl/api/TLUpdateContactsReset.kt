package com.github.badoualy.telegram.tl.api

/**
 * updateContactsReset#7084a7be
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateContactsReset : TLAbsUpdate() {
    private val _constructor: String = "updateContactsReset#7084a7be"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateContactsReset) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7084a7be.toInt()
    }
}
