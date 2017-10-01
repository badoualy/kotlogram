package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [draftMessage#fd8e711f][TLDraftMessage]
 * * [draftMessageEmpty#ba4baec5][TLDraftMessageEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsDraftMessage : TLObject() {
    fun isEmpty(): Boolean = this is TLDraftMessageEmpty

    fun isNotEmpty(): Boolean = this is TLDraftMessage

    fun asDraftMessage(): TLDraftMessage? = this as? TLDraftMessage
}
