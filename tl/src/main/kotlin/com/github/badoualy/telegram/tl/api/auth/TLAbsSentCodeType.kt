package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [auth.sentCodeTypeApp#3dbb5986][TLSentCodeTypeApp]
 * * [auth.sentCodeTypeCall#5353e5a7][TLSentCodeTypeCall]
 * * [auth.sentCodeTypeFlashCall#ab03c6d9][TLSentCodeTypeFlashCall]
 * * [auth.sentCodeTypeSms#c000bba2][TLSentCodeTypeSms]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsSentCodeType : TLObject()
