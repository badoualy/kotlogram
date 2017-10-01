package com.github.badoualy.telegram.tl.api

/**
 * messageMediaEmpty#3ded6320
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaEmpty : TLAbsMessageMedia() {
    private val _constructor: String = "messageMediaEmpty#3ded6320"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3ded6320.toInt()
    }
}
