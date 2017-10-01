package com.github.badoualy.telegram.tl.api

/**
 * inputChannelEmpty#ee8c1e86
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputChannelEmpty : TLAbsInputChannel() {
    private val _constructor: String = "inputChannelEmpty#ee8c1e86"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputChannelEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xee8c1e86.toInt()
    }
}
