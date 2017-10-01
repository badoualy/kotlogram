package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [updateShort#78d4dec1][TLUpdateShort]
 * * [updateShortChatMessage#16812688][TLUpdateShortChatMessage]
 * * [updateShortMessage#914fbf11][TLUpdateShortMessage]
 * * [updateShortSentMessage#11f1331c][TLUpdateShortSentMessage]
 * * [updates#74ae4240][TLUpdates]
 * * [updatesCombined#725b04c3][TLUpdatesCombined]
 * * [updatesTooLong#e317af7e][TLUpdatesTooLong]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsUpdates : TLObject()
