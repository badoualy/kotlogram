package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [peerNotifyEventsAll#6d1ded88][TLPeerNotifyEventsAll]
 * * [peerNotifyEventsEmpty#add53cb3][TLPeerNotifyEventsEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPeerNotifyEvents : TLObject() {
    fun isEmpty(): Boolean = this is TLPeerNotifyEventsEmpty

    fun isNotEmpty(): Boolean = this is TLPeerNotifyEventsAll

    fun asPeerNotifyEventsAll(): TLPeerNotifyEventsAll? = this as? TLPeerNotifyEventsAll
}
