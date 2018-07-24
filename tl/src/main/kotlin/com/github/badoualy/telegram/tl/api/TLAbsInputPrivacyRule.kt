package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputPrivacyValueAllowAll#184b35ce][TLInputPrivacyValueAllowAll]
 * * [inputPrivacyValueAllowContacts#d09e07b][TLInputPrivacyValueAllowContacts]
 * * [inputPrivacyValueAllowUsers#131cc67f][TLInputPrivacyValueAllowUsers]
 * * [inputPrivacyValueDisallowAll#d66b66c9][TLInputPrivacyValueDisallowAll]
 * * [inputPrivacyValueDisallowContacts#ba52007][TLInputPrivacyValueDisallowContacts]
 * * [inputPrivacyValueDisallowUsers#90110467][TLInputPrivacyValueDisallowUsers]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputPrivacyRule : TLObject()
