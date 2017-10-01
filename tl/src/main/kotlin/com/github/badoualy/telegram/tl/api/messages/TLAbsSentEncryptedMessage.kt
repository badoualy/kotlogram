package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [messages.sentEncryptedFile#9493ff32][TLSentEncryptedFile]
 * * [messages.sentEncryptedMessage#560f8935][TLSentEncryptedMessage]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsSentEncryptedMessage : TLObject() {
    abstract var date: Int
}
