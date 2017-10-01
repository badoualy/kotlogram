package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputPeerNotifyEventsAll#e86a2c74][TLInputPeerNotifyEventsAll]
 * * [inputPeerNotifyEventsEmpty#f03064d8][TLInputPeerNotifyEventsEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputPeerNotifyEvents : TLObject() {
    fun isEmpty(): Boolean = this is TLInputPeerNotifyEventsEmpty

    fun isNotEmpty(): Boolean = this is TLInputPeerNotifyEventsAll

    fun asInputPeerNotifyEventsAll(): TLInputPeerNotifyEventsAll? = this as? TLInputPeerNotifyEventsAll
}
