package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLContactLinkContact}: contactLinkContact#d502c2d0</li>
 * <li>{@link TLContactLinkHasPhone}: contactLinkHasPhone#268f3f59</li>
 * <li>{@link TLContactLinkNone}: contactLinkNone#feedd3ad</li>
 * <li>{@link TLContactLinkUnknown}: contactLinkUnknown#5f4f9247</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsContactLink extends TLObject {

    public TLAbsContactLink() {
    }
}
