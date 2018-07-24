package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.String

/**
 * Abstraction level for the following constructors:
 * * [keyboardButton#a2fa4880][TLKeyboardButton]
 * * [keyboardButtonBuy#afd93fbb][TLKeyboardButtonBuy]
 * * [keyboardButtonCallback#683a5e46][TLKeyboardButtonCallback]
 * * [keyboardButtonGame#50f41ccf][TLKeyboardButtonGame]
 * * [keyboardButtonRequestGeoLocation#fc796b3f][TLKeyboardButtonRequestGeoLocation]
 * * [keyboardButtonRequestPhone#b16a6c29][TLKeyboardButtonRequestPhone]
 * * [keyboardButtonSwitchInline#568a748][TLKeyboardButtonSwitchInline]
 * * [keyboardButtonUrl#258aff05][TLKeyboardButtonUrl]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsKeyboardButton : TLObject() {
    abstract var text: String
}
