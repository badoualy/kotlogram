package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [document#87232bc7][TLDocument]
 * * [documentEmpty#36f8c871][TLDocumentEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsDocument : TLObject() {
    abstract var id: Long

    fun isEmpty(): Boolean = this is TLDocumentEmpty

    fun isNotEmpty(): Boolean = this is TLDocument

    fun asDocument(): TLDocument? = this as? TLDocument
}
