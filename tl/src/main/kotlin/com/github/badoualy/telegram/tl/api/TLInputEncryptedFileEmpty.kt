package com.github.badoualy.telegram.tl.api

/**
 * inputEncryptedFileEmpty#1837c364
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputEncryptedFileEmpty : TLAbsInputEncryptedFile() {
    private val _constructor: String = "inputEncryptedFileEmpty#1837c364"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputEncryptedFileEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1837c364.toInt()
    }
}
