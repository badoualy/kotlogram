package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [messages.recentStickers#5ce20970][TLRecentStickers]
 * * [messages.recentStickersNotModified#b17f890][TLRecentStickersNotModified]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsRecentStickers : TLObject()
