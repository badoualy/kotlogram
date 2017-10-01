package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [encryptedMessage#ed18c118][TLEncryptedMessage]
 * * [encryptedMessageService#23734b06][TLEncryptedMessageService]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsEncryptedMessage : TLObject() {
    abstract var randomId: Long

    abstract var chatId: Int

    abstract var date: Int

    abstract var bytes: TLBytes
}
