package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLSentCodeTypeApp}: auth.sentCodeTypeApp#3dbb5986</li>
 * <li>{@link TLSentCodeTypeCall}: auth.sentCodeTypeCall#5353e5a7</li>
 * <li>{@link TLSentCodeTypeFlashCall}: auth.sentCodeTypeFlashCall#ab03c6d9</li>
 * <li>{@link TLSentCodeTypeSms}: auth.sentCodeTypeSms#c000bba2</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsSentCodeType extends TLObject {

    public TLAbsSentCodeType() {
    }
}
