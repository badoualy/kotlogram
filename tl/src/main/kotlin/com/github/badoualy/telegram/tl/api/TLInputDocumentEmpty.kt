package com.github.badoualy.telegram.tl.api

/**
 * inputDocumentEmpty#72f0eaae
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputDocumentEmpty : TLAbsInputDocument() {
    private val _constructor: String = "inputDocumentEmpty#72f0eaae"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputDocumentEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x72f0eaae.toInt()
    }
}
