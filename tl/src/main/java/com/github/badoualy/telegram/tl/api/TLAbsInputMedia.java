package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputMediaContact}: inputMediaContact#a6e45987</li>
 * <li>{@link TLInputMediaDocument}: inputMediaDocument#1a77f29c</li>
 * <li>{@link TLInputMediaDocumentExternal}: inputMediaDocumentExternal#e5e9607c</li>
 * <li>{@link TLInputMediaEmpty}: inputMediaEmpty#9664f57f</li>
 * <li>{@link TLInputMediaGame}: inputMediaGame#d33f43f3</li>
 * <li>{@link TLInputMediaGeoPoint}: inputMediaGeoPoint#f9c44144</li>
 * <li>{@link TLInputMediaGifExternal}: inputMediaGifExternal#4843b0fd</li>
 * <li>{@link TLInputMediaInvoice}: inputMediaInvoice#92153685</li>
 * <li>{@link TLInputMediaPhoto}: inputMediaPhoto#e9bfb4f3</li>
 * <li>{@link TLInputMediaPhotoExternal}: inputMediaPhotoExternal#b55f4f18</li>
 * <li>{@link TLInputMediaUploadedDocument}: inputMediaUploadedDocument#d070f1e9</li>
 * <li>{@link TLInputMediaUploadedPhoto}: inputMediaUploadedPhoto#630c9af1</li>
 * <li>{@link TLInputMediaUploadedThumbDocument}: inputMediaUploadedThumbDocument#50d88cae</li>
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
