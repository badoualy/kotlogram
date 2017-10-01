package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputDocument#18798952][TLInputDocument]
 * * [inputDocumentEmpty#72f0eaae][TLInputDocumentEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputDocument : TLObject() {
    fun isEmpty(): Boolean = this is TLInputDocumentEmpty

    fun isNotEmpty(): Boolean = this is TLInputDocument

    fun asInputDocument(): TLInputDocument? = this as? TLInputDocument
}
