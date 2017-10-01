package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [payments.paymentResult#4e5f810d][TLPaymentResult]
 * * [payments.paymentVerficationNeeded#6b56b921][TLPaymentVerficationNeeded]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPaymentResult : TLObject()
