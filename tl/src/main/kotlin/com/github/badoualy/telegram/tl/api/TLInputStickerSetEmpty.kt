package com.github.badoualy.telegram.tl.api

/**
 * inputStickerSetEmpty#ffb62b95
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputStickerSetEmpty : TLAbsInputStickerSet() {
    private val _constructor: String = "inputStickerSetEmpty#ffb62b95"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputStickerSetEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xffb62b95.toInt()
    }
}
