package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputMediaContact#a6e45987][TLInputMediaContact]
 * * [inputMediaDocument#5acb668e][TLInputMediaDocument]
 * * [inputMediaDocumentExternal#b6f74335][TLInputMediaDocumentExternal]
 * * [inputMediaEmpty#9664f57f][TLInputMediaEmpty]
 * * [inputMediaGame#d33f43f3][TLInputMediaGame]
 * * [inputMediaGeoLive#7b1a118f][TLInputMediaGeoLive]
 * * [inputMediaGeoPoint#f9c44144][TLInputMediaGeoPoint]
 * * [inputMediaGifExternal#4843b0fd][TLInputMediaGifExternal]
 * * [inputMediaInvoice#92153685][TLInputMediaInvoice]
 * * [inputMediaPhoto#81fa373a][TLInputMediaPhoto]
 * * [inputMediaPhotoExternal#922aec1][TLInputMediaPhotoExternal]
 * * [inputMediaUploadedDocument#e39621fd][TLInputMediaUploadedDocument]
 * * [inputMediaUploadedPhoto#2f37e231][TLInputMediaUploadedPhoto]
 * * [inputMediaVenue#c13d1c11][TLInputMediaVenue]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputMedia : TLObject()
