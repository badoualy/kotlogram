package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.account.TLAbsPassword
import com.github.badoualy.telegram.tl.core.TLMethod

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountGetPassword : TLMethod<TLAbsPassword>() {
    private val _constructor: String = "account.getPassword#548a30f5"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetPassword) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x548a30f5.toInt()
    }
}
