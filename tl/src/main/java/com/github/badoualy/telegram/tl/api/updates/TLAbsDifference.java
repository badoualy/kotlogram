package com.github.badoualy.telegram.tl.api.updates;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLDifference}: updates.difference#f49ca0</li>
 * <li>{@link TLDifferenceEmpty}: updates.differenceEmpty#5d75a138</li>
 * <li>{@link TLDifferenceSlice}: updates.differenceSlice#a8fb1981</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsDifference extends TLObject {
    public TLAbsDifference() {
    }
}
