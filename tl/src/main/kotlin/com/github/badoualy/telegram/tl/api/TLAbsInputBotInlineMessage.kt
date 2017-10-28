package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputBotInlineMessageGame#4b425864][TLInputBotInlineMessageGame]
 * * [inputBotInlineMessageMediaAuto#292fed13][TLInputBotInlineMessageMediaAuto]
 * * [inputBotInlineMessageMediaContact#2daf01a7][TLInputBotInlineMessageMediaContact]
 * * [inputBotInlineMessageMediaGeo#c1b15d65][TLInputBotInlineMessageMediaGeo]
 * * [inputBotInlineMessageMediaVenue#aaafadc8][TLInputBotInlineMessageMediaVenue]
 * * [inputBotInlineMessageText#3dcd7a87][TLInputBotInlineMessageText]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputBotInlineMessage : TLObject() {
    abstract var replyMarkup: TLAbsReplyMarkup?
}
