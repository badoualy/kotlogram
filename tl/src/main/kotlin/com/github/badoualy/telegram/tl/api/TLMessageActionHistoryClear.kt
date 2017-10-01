package com.github.badoualy.telegram.tl.api

/**
 * messageActionHistoryClear#9fbab604
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionHistoryClear : TLAbsMessageAction() {
    private val _constructor: String = "messageActionHistoryClear#9fbab604"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionHistoryClear) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9fbab604.toInt()
    }
}
