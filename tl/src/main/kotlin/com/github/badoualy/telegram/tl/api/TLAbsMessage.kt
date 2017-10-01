package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [message#90dddc11][TLMessage]
 * * [messageEmpty#83e5de54][TLMessageEmpty]
 * * [messageService#9e19a1f6][TLMessageService]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessage : TLObject() {
    abstract var id: Int
}
