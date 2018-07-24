package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputMediaContact#f8ab7dfb][TLInputMediaContact]
 * * [inputMediaDocument#23ab23d2][TLInputMediaDocument]
 * * [inputMediaDocumentExternal#fb52dc99][TLInputMediaDocumentExternal]
 * * [inputMediaEmpty#9664f57f][TLInputMediaEmpty]
 * * [inputMediaGame#d33f43f3][TLInputMediaGame]
 * * [inputMediaGeoLive#7b1a118f][TLInputMediaGeoLive]
 * * [inputMediaGeoPoint#f9c44144][TLInputMediaGeoPoint]
 * * [inputMediaGifExternal#4843b0fd][TLInputMediaGifExternal]
 * * [inputMediaInvoice#f4e096c3][TLInputMediaInvoice]
 * * [inputMediaPhoto#b3ba0635][TLInputMediaPhoto]
 * * [inputMediaPhotoExternal#e5bbfe1a][TLInputMediaPhotoExternal]
 * * [inputMediaUploadedDocument#5b38c6c1][TLInputMediaUploadedDocument]
 * * [inputMediaUploadedPhoto#1e287d04][TLInputMediaUploadedPhoto]
 * * [inputMediaVenue#c13d1c11][TLInputMediaVenue]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputMedia : TLObject()
