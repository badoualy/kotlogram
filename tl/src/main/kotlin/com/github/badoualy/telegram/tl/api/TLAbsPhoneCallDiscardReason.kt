package com.github.badoualy.telegram.tl.api

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
