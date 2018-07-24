package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.Boolean
import kotlin.Int

/**
 * Abstraction level for the following constructors:
 * * [help.proxyDataEmpty#e09e1fb8][TLProxyDataEmpty]
 * * [help.proxyDataPromo#2bf7ee23][TLProxyDataPromo]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsProxyData : TLObject() {
    abstract var expires: Int

    fun isEmpty(): Boolean = this is TLProxyDataEmpty

    fun isNotEmpty(): Boolean = this is TLProxyDataPromo

    fun asProxyDataPromo(): TLProxyDataPromo? = this as? TLProxyDataPromo
}
