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
 * * [secureValueTypeAddress#cbe31e26][TLSecureValueTypeAddress]
 * * [secureValueTypeBankStatement#89137c0d][TLSecureValueTypeBankStatement]
 * * [secureValueTypeDriverLicense#6e425c4][TLSecureValueTypeDriverLicense]
 * * [secureValueTypeEmail#8e3ca7ee][TLSecureValueTypeEmail]
 * * [secureValueTypeIdentityCard#a0d0744b][TLSecureValueTypeIdentityCard]
 * * [secureValueTypeInternalPassport#99a48f23][TLSecureValueTypeInternalPassport]
 * * [secureValueTypePassport#3dac6a00][TLSecureValueTypePassport]
 * * [secureValueTypePassportRegistration#99e3806a][TLSecureValueTypePassportRegistration]
 * * [secureValueTypePersonalDetails#9d2a81e3][TLSecureValueTypePersonalDetails]
 * * [secureValueTypePhone#b320aadb][TLSecureValueTypePhone]
 * * [secureValueTypeRentalAgreement#8b883488][TLSecureValueTypeRentalAgreement]
 * * [secureValueTypeTemporaryRegistration#ea02ec33][TLSecureValueTypeTemporaryRegistration]
 * * [secureValueTypeUtilityBill#fc36954e][TLSecureValueTypeUtilityBill]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsSecureValueType : TLObject()
