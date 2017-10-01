package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [account.noPassword#96dabc18][TLNoPassword]
 * * [account.password#7c18141c][TLPassword]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPassword : TLObject() {
    abstract var newSalt: TLBytes

    abstract var emailUnconfirmedPattern: String
}
