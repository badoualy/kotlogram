package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLCodeTypeCall}: auth.codeTypeCall#741cd3e3</li>
 * <li>{@link TLCodeTypeFlashCall}: auth.codeTypeFlashCall#226ccefb</li>
 * <li>{@link TLCodeTypeSms}: auth.codeTypeSms#72a3158c</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsCodeType extends TLObject {

    public TLAbsCodeType() {
    }
}
