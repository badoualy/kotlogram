package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [botInlineMessageMediaAuto#a74b15b][TLBotInlineMessageMediaAuto]
 * * [botInlineMessageMediaContact#35edb4d4][TLBotInlineMessageMediaContact]
 * * [botInlineMessageMediaGeo#b722de65][TLBotInlineMessageMediaGeo]
 * * [botInlineMessageMediaVenue#4366232e][TLBotInlineMessageMediaVenue]
 * * [botInlineMessageText#8c7f65e2][TLBotInlineMessageText]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsBotInlineMessage : TLObject() {
    abstract var replyMarkup: TLAbsReplyMarkup?
}
