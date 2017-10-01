package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [notifyAll#74d07c60][TLNotifyAll]
 * * [notifyChats#c007cec3][TLNotifyChats]
 * * [notifyPeer#9fd40bd8][TLNotifyPeer]
 * * [notifyUsers#b4c83b4c][TLNotifyUsers]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsNotifyPeer : TLObject()
