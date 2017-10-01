package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [documentAttributeAnimated#11b58939][TLDocumentAttributeAnimated]
 * * [documentAttributeAudio#9852f9c6][TLDocumentAttributeAudio]
 * * [documentAttributeFilename#15590068][TLDocumentAttributeFilename]
 * * [documentAttributeHasStickers#9801d2f7][TLDocumentAttributeHasStickers]
 * * [documentAttributeImageSize#6c37c15c][TLDocumentAttributeImageSize]
 * * [documentAttributeSticker#6319d612][TLDocumentAttributeSticker]
 * * [documentAttributeVideo#ef02ce6][TLDocumentAttributeVideo]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsDocumentAttribute : TLObject()
