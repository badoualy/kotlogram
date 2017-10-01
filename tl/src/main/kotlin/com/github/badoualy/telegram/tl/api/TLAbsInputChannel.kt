package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputChannel#afeb712e][TLInputChannel]
 * * [inputChannelEmpty#ee8c1e86][TLInputChannelEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputChannel : TLObject() {
    fun isEmpty(): Boolean = this is TLInputChannelEmpty

    fun isNotEmpty(): Boolean = this is TLInputChannel

    fun asInputChannel(): TLInputChannel? = this as? TLInputChannel
}
