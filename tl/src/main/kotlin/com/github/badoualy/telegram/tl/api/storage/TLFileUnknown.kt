package com.github.badoualy.telegram.tl.api.storage

/**
 * storage.fileUnknown#aa963b05
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFileUnknown : TLAbsFileType() {
    private val _constructor: String = "storage.fileUnknown#aa963b05"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFileUnknown) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xaa963b05.toInt()
    }
}
