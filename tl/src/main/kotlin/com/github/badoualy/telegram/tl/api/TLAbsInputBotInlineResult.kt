package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.String

/**
 * Abstraction level for the following constructors:
 * * [inputBotInlineResult#88bf9319][TLInputBotInlineResult]
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
