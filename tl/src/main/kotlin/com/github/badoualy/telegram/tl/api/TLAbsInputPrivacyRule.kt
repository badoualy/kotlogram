package com.github.badoualy.telegram.tl.api

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
