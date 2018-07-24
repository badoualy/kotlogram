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
 * * [messageMediaContact#cbf24940][TLMessageMediaContact]
 * * [messageMediaDocument#9cb070d7][TLMessageMediaDocument]
 * * [messageMediaEmpty#3ded6320][TLMessageMediaEmpty]
 * * [messageMediaGame#fdb19008][TLMessageMediaGame]
 * * [messageMediaGeo#56e0d474][TLMessageMediaGeo]
 * * [messageMediaGeoLive#7c3c2609][TLMessageMediaGeoLive]
 * * [messageMediaInvoice#84551347][TLMessageMediaInvoice]
 * * [messageMediaPhoto#695150d7][TLMessageMediaPhoto]
 * * [messageMediaUnsupported#9f84f49e][TLMessageMediaUnsupported]
 * * [messageMediaVenue#2ec0533f][TLMessageMediaVenue]
 * * [messageMediaWebPage#a32dd600][TLMessageMediaWebPage]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessageMedia : TLObject()
