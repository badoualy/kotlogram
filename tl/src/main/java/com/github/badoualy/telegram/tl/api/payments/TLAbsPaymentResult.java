package com.github.badoualy.telegram.tl.api.payments;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPaymentResult}: payments.paymentResult#4e5f810d</li>
 * <li>{@link TLPaymentVerficationNeeded}: payments.paymentVerficationNeeded#6b56b921</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPaymentResult extends TLObject {

    public TLAbsPaymentResult() {
    }
}
