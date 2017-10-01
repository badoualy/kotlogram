package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [phoneCall#ffe6ab67][TLPhoneCall]
 * * [phoneCallAccepted#6d003d3f][TLPhoneCallAccepted]
 * * [phoneCallDiscarded#50ca4de1][TLPhoneCallDiscarded]
 * * [phoneCallEmpty#5366c915][TLPhoneCallEmpty]
 * * [phoneCallRequested#83761ce4][TLPhoneCallRequested]
 * * [phoneCallWaiting#1b8f4ad1][TLPhoneCallWaiting]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPhoneCall : TLObject() {
    abstract var id: Long
}
