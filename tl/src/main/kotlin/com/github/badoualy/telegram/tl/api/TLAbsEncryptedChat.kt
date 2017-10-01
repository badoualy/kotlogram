package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [encryptedChat#fa56ce36][TLEncryptedChat]
 * * [encryptedChatDiscarded#13d6dd27][TLEncryptedChatDiscarded]
 * * [encryptedChatEmpty#ab7ec0a0][TLEncryptedChatEmpty]
 * * [encryptedChatRequested#c878527e][TLEncryptedChatRequested]
 * * [encryptedChatWaiting#3bf703dc][TLEncryptedChatWaiting]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsEncryptedChat : TLObject() {
    abstract var id: Int
}
