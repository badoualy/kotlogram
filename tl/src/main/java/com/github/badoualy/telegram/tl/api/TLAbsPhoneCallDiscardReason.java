package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPhoneCallDiscardReasonBusy}: phoneCallDiscardReasonBusy#faf7e8c9</li>
 * <li>{@link TLPhoneCallDiscardReasonDisconnect}: phoneCallDiscardReasonDisconnect#e095c1a0</li>
 * <li>{@link TLPhoneCallDiscardReasonHangup}: phoneCallDiscardReasonHangup#57adc690</li>
 * <li>{@link TLPhoneCallDiscardReasonMissed}: phoneCallDiscardReasonMissed#85e42301</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPhoneCallDiscardReason extends TLObject {

    public TLAbsPhoneCallDiscardReason() {
    }
}
