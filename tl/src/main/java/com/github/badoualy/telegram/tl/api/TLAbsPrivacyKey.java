package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPrivacyKeyChatInvite}: privacyKeyChatInvite#500e6dfa</li>
 * <li>{@link TLPrivacyKeyPhoneCall}: privacyKeyPhoneCall#3d662b7b</li>
 * <li>{@link TLPrivacyKeyStatusTimestamp}: privacyKeyStatusTimestamp#bc2eab30</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPrivacyKey extends TLObject {

    public TLAbsPrivacyKey() {
    }
}
