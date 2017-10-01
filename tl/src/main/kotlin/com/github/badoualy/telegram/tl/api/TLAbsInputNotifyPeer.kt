package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputNotifyAll#a429b886][TLInputNotifyAll]
 * * [inputNotifyChats#4a95e84e][TLInputNotifyChats]
 * * [inputNotifyPeer#b8bc5b0c][TLInputNotifyPeer]
 * * [inputNotifyUsers#193b4417][TLInputNotifyUsers]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputNotifyPeer : TLObject()
