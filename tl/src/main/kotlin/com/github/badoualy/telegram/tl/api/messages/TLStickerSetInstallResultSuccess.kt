package com.github.badoualy.telegram.tl.api.messages

/**
 * messages.stickerSetInstallResultSuccess#38641628
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStickerSetInstallResultSuccess : TLAbsStickerSetInstallResult() {
    private val _constructor: String = "messages.stickerSetInstallResultSuccess#38641628"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStickerSetInstallResultSuccess) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x38641628.toInt()
    }
}
