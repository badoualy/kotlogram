package com.github.badoualy.telegram.tl.api.storage

/**
 * storage.fileWebp#1081464c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFileWebp : TLAbsFileType() {
    private val _constructor: String = "storage.fileWebp#1081464c"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFileWebp) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1081464c.toInt()
    }
}
