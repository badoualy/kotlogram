package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.String

/**
 * Abstraction level for the following constructors:
 * * [secureValueErrorData#e8a40bd9][TLSecureValueErrorData]
 * * [secureValueErrorFile#7a700873][TLSecureValueErrorFile]
 * * [secureValueErrorFiles#666220e9][TLSecureValueErrorFiles]
 * * [secureValueErrorFrontSide#be3dfa][TLSecureValueErrorFrontSide]
 * * [secureValueErrorReverseSide#868a2aa5][TLSecureValueErrorReverseSide]
 * * [secureValueErrorSelfie#e537ced6][TLSecureValueErrorSelfie]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsSecureValueError : TLObject() {
    abstract var type: TLAbsSecureValueType

    abstract var text: String
}
