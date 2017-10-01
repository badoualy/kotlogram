package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [replyInlineMarkup#48a30254][TLReplyInlineMarkup]
 * * [replyKeyboardForceReply#f4108aa0][TLReplyKeyboardForceReply]
 * * [replyKeyboardHide#a03e5b85][TLReplyKeyboardHide]
 * * [replyKeyboardMarkup#3502758c][TLReplyKeyboardMarkup]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsReplyMarkup : TLObject()
