package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [user#2e13f4c3][TLUser]
 * * [userEmpty#200250ba][TLUserEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsUser : TLObject() {
    abstract var id: Int

    fun isEmpty(): Boolean = this is TLUserEmpty

    fun isNotEmpty(): Boolean = this is TLUser

    fun asUser(): TLUser? = this as? TLUser
}
