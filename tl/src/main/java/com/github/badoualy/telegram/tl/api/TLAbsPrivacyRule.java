package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPrivacyValueAllowAll}: privacyValueAllowAll#65427b82</li>
 * <li>{@link TLPrivacyValueAllowContacts}: privacyValueAllowContacts#fffe1bac</li>
 * <li>{@link TLPrivacyValueAllowUsers}: privacyValueAllowUsers#4d5bbe0c</li>
 * <li>{@link TLPrivacyValueDisallowAll}: privacyValueDisallowAll#8b73e763</li>
 * <li>{@link TLPrivacyValueDisallowContacts}: privacyValueDisallowContacts#f888fa1a</li>
 * <li>{@link TLPrivacyValueDisallowUsers}: privacyValueDisallowUsers#c7f49b7</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPrivacyRule extends TLObject {

    public TLAbsPrivacyRule() {
    }
}
