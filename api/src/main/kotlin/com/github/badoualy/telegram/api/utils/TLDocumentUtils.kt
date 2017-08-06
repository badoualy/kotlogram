package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.TLAbsDocument
import com.github.badoualy.telegram.tl.api.TLDocument
import com.github.badoualy.telegram.tl.api.TLInputDocument
import com.github.badoualy.telegram.tl.api.TLInputDocumentEmpty

fun TLAbsDocument.toInputDocument() = when (this) {
    is TLDocument -> TLInputDocument(id, accessHash)
    else -> TLInputDocumentEmpty()
}