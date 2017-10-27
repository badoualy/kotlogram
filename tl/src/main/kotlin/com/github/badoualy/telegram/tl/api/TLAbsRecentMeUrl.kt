package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [recentMeUrlChat#a01b22f9][TLRecentMeUrlChat]
 * * [recentMeUrlChatInvite#eb49081d][TLRecentMeUrlChatInvite]
 * * [recentMeUrlStickerSet#bc0a57dc][TLRecentMeUrlStickerSet]
 * * [recentMeUrlUnknown#46e1d13d][TLRecentMeUrlUnknown]
 * * [recentMeUrlUser#8dbc3336][TLRecentMeUrlUser]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsRecentMeUrl : TLObject() {
    abstract var url: String
}
