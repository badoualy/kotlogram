package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputPrivacyKeyChatInvite}: inputPrivacyKeyChatInvite#bdfb0426</li>
 * <li>{@link TLInputPrivacyKeyPhoneCall}: inputPrivacyKeyPhoneCall#fabadc5f</li>
 * <li>{@link TLInputPrivacyKeyStatusTimestamp}: inputPrivacyKeyStatusTimestamp#4f96cb18</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputPrivacyKey extends TLObject {

    public TLAbsInputPrivacyKey() {
    }
}
