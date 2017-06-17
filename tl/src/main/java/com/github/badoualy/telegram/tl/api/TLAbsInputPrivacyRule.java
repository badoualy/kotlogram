package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputPrivacyValueAllowAll}: inputPrivacyValueAllowAll#184b35ce</li>
 * <li>{@link TLInputPrivacyValueAllowContacts}: inputPrivacyValueAllowContacts#d09e07b</li>
 * <li>{@link TLInputPrivacyValueAllowUsers}: inputPrivacyValueAllowUsers#131cc67f</li>
 * <li>{@link TLInputPrivacyValueDisallowAll}: inputPrivacyValueDisallowAll#d66b66c9</li>
 * <li>{@link TLInputPrivacyValueDisallowContacts}: inputPrivacyValueDisallowContacts#ba52007</li>
 * <li>{@link TLInputPrivacyValueDisallowUsers}: inputPrivacyValueDisallowUsers#90110467</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputPrivacyRule extends TLObject {

    public TLAbsInputPrivacyRule() {
    }
}
