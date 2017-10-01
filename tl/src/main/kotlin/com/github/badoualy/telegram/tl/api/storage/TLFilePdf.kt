package com.github.badoualy.telegram.tl.api.storage

/**
 * storage.filePdf#ae1e508d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFilePdf : TLAbsFileType() {
    private val _constructor: String = "storage.filePdf#ae1e508d"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFilePdf) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xae1e508d.toInt()
    }
}
