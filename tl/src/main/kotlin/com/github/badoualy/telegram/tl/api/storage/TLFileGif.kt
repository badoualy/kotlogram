package com.github.badoualy.telegram.tl.api.storage

/**
 * storage.fileGif#cae1aadf
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFileGif : TLAbsFileType() {
    private val _constructor: String = "storage.fileGif#cae1aadf"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFileGif) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcae1aadf.toInt()
    }
}
