package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputBotInlineResult#2cbbe15a][TLInputBotInlineResult]
 * * [inputBotInlineResultDocument#fff8fdc4][TLInputBotInlineResultDocument]
 * * [inputBotInlineResultGame#4fa417f2][TLInputBotInlineResultGame]
 * * [inputBotInlineResultPhoto#a8d864a7][TLInputBotInlineResultPhoto]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputBotInlineResult : TLObject() {
    abstract var id: String

    abstract var sendMessage: TLAbsInputBotInlineMessage
}
