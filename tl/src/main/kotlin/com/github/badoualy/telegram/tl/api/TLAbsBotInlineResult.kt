package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [botInlineMediaResult#17db940b][TLBotInlineMediaResult]
 * * [botInlineResult#9bebaeb9][TLBotInlineResult]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsBotInlineResult : TLObject() {
    abstract var id: String

    abstract var type: String

    abstract var sendMessage: TLAbsBotInlineMessage
}
