package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputPrivacyKeyChatInvite#bdfb0426][TLInputPrivacyKeyChatInvite]
 * * [inputPrivacyKeyPhoneCall#fabadc5f][TLInputPrivacyKeyPhoneCall]
 * * [inputPrivacyKeyStatusTimestamp#4f96cb18][TLInputPrivacyKeyStatusTimestamp]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputPrivacyKey : TLObject()
