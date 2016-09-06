package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputMediaContact}: inputMediaContact#a6e45987</li>
 * <li>{@link TLInputMediaDocument}: inputMediaDocument#1a77f29c</li>
 * <li>{@link TLInputMediaEmpty}: inputMediaEmpty#9664f57f</li>
 * <li>{@link TLInputMediaGeoPoint}: inputMediaGeoPoint#f9c44144</li>
 * <li>{@link TLInputMediaGifExternal}: inputMediaGifExternal#4843b0fd</li>
 * <li>{@link TLInputMediaPhoto}: inputMediaPhoto#e9bfb4f3</li>
 * <li>{@link TLInputMediaUploadedDocument}: inputMediaUploadedDocument#1d89306d</li>
 * <li>{@link TLInputMediaUploadedPhoto}: inputMediaUploadedPhoto#f7aff1c0</li>
 * <li>{@link TLInputMediaUploadedThumbDocument}: inputMediaUploadedThumbDocument#ad613491</li>
 * <li>{@link TLInputMediaVenue}: inputMediaVenue#2827a81a</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputMedia extends TLObject {
    public TLAbsInputMedia() {
    }
}
