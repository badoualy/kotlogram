package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [peerNotifySettings#9acda4c0][TLPeerNotifySettings]
 * * [peerNotifySettingsEmpty#70a68512][TLPeerNotifySettingsEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPeerNotifySettings : TLObject() {
    fun isEmpty(): Boolean = this is TLPeerNotifySettingsEmpty

    fun isNotEmpty(): Boolean = this is TLPeerNotifySettings

    fun asPeerNotifySettings(): TLPeerNotifySettings? = this as? TLPeerNotifySettings
}
