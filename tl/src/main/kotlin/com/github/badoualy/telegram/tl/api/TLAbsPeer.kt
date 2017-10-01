package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [peerChannel#bddde532][TLPeerChannel]
 * * [peerChat#bad0e5bb][TLPeerChat]
 * * [peerUser#9db1bc6d][TLPeerUser]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPeer : TLObject()
