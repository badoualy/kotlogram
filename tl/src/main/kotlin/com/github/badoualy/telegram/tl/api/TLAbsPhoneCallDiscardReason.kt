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
 * * [phoneCallDiscardReasonBusy#faf7e8c9][TLPhoneCallDiscardReasonBusy]
 * * [phoneCallDiscardReasonDisconnect#e095c1a0][TLPhoneCallDiscardReasonDisconnect]
 * * [phoneCallDiscardReasonHangup#57adc690][TLPhoneCallDiscardReasonHangup]
 * * [phoneCallDiscardReasonMissed#85e42301][TLPhoneCallDiscardReasonMissed]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPhoneCallDiscardReason : TLObject()
