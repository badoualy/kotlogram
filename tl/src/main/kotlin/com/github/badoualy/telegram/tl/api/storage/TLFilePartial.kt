package com.github.badoualy.telegram.tl.api.storage

/**
 * storage.filePartial#40bc6f52
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFilePartial : TLAbsFileType() {
    private val _constructor: String = "storage.filePartial#40bc6f52"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFilePartial) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x40bc6f52.toInt()
    }
}
