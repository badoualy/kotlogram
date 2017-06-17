package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLDocumentAttributeAnimated}: documentAttributeAnimated#11b58939</li>
 * <li>{@link TLDocumentAttributeAudio}: documentAttributeAudio#9852f9c6</li>
 * <li>{@link TLDocumentAttributeFilename}: documentAttributeFilename#15590068</li>
 * <li>{@link TLDocumentAttributeHasStickers}: documentAttributeHasStickers#9801d2f7</li>
 * <li>{@link TLDocumentAttributeImageSize}: documentAttributeImageSize#6c37c15c</li>
 * <li>{@link TLDocumentAttributeSticker}: documentAttributeSticker#6319d612</li>
 * <li>{@link TLDocumentAttributeVideo}: documentAttributeVideo#ef02ce6</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsDocumentAttribute extends TLObject {

    public TLAbsDocumentAttribute() {
    }
}
