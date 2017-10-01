package com.github.badoualy.telegram.tl.api

/**
 * encryptedFileEmpty#c21f497e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEncryptedFileEmpty : TLAbsEncryptedFile() {
    private val _constructor: String = "encryptedFileEmpty#c21f497e"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEncryptedFileEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc21f497e.toInt()
    }
}
