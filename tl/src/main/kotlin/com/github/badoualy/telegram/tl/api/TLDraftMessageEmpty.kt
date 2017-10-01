package com.github.badoualy.telegram.tl.api

/**
 * draftMessageEmpty#ba4baec5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDraftMessageEmpty : TLAbsDraftMessage() {
    private val _constructor: String = "draftMessageEmpty#ba4baec5"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDraftMessageEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xba4baec5.toInt()
    }
}
