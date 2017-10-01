package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [privacyKeyChatInvite#500e6dfa][TLPrivacyKeyChatInvite]
 * * [privacyKeyPhoneCall#3d662b7b][TLPrivacyKeyPhoneCall]
 * * [privacyKeyStatusTimestamp#bc2eab30][TLPrivacyKeyStatusTimestamp]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPrivacyKey : TLObject()
