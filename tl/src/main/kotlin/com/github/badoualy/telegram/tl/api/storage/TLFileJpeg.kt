package com.github.badoualy.telegram.tl.api.storage

/**
 * storage.fileJpeg#7efe0e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFileJpeg : TLAbsFileType() {
    private val _constructor: String = "storage.fileJpeg#7efe0e"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFileJpeg) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7efe0e.toInt()
    }
}
