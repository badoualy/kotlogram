package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [channel#cb44b1c][TLChannel]
 * * [channelForbidden#289da732][TLChannelForbidden]
 * * [chat#d91cdd54][TLChat]
 * * [chatEmpty#9ba2d800][TLChatEmpty]
 * * [chatForbidden#7328bdb][TLChatForbidden]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChat : TLObject() {
    abstract var id: Int
}
