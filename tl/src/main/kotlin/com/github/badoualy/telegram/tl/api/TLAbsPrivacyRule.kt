package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [privacyValueAllowAll#65427b82][TLPrivacyValueAllowAll]
 * * [privacyValueAllowContacts#fffe1bac][TLPrivacyValueAllowContacts]
 * * [privacyValueAllowUsers#4d5bbe0c][TLPrivacyValueAllowUsers]
 * * [privacyValueDisallowAll#8b73e763][TLPrivacyValueDisallowAll]
 * * [privacyValueDisallowContacts#f888fa1a][TLPrivacyValueDisallowContacts]
 * * [privacyValueDisallowUsers#c7f49b7][TLPrivacyValueDisallowUsers]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPrivacyRule : TLObject()
