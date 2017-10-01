package com.github.badoualy.telegram.tl.api.contacts

import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLContactBlocked
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector

/**
 * Abstraction level for the following constructors:
 * * [contacts.blocked#1c138d15][TLBlocked]
 * * [contacts.blockedSlice#900802a1][TLBlockedSlice]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsBlocked : TLObject() {
    abstract var blocked: TLObjectVector<TLContactBlocked>

    abstract var users: TLObjectVector<TLAbsUser>
}
