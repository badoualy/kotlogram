package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLTextBold}: textBold#6724abc4</li>
 * <li>{@link TLTextConcat}: textConcat#7e6260d7</li>
 * <li>{@link TLTextEmail}: textEmail#de5a0dd6</li>
 * <li>{@link TLTextEmpty}: textEmpty#dc3d824f</li>
 * <li>{@link TLTextFixed}: textFixed#6c3f19b9</li>
 * <li>{@link TLTextItalic}: textItalic#d912a59c</li>
 * <li>{@link TLTextPlain}: textPlain#744694e0</li>
 * <li>{@link TLTextStrike}: textStrike#9bf8bb95</li>
 * <li>{@link TLTextUnderline}: textUnderline#c12622c4</li>
 * <li>{@link TLTextUrl}: textUrl#3c2884c1</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsRichText extends TLObject {

    public TLAbsRichText() {
    }
}
