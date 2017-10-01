package com.github.badoualy.telegram.tl.api.storage

/**
 * storage.fileMp4#b3cea0e4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFileMp4 : TLAbsFileType() {
    private val _constructor: String = "storage.fileMp4#b3cea0e4"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFileMp4) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb3cea0e4.toInt()
    }
}
