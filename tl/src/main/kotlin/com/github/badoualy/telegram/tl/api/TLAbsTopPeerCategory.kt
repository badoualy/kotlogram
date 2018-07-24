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
 * * [topPeerCategoryBotsInline#148677e2][TLTopPeerCategoryBotsInline]
 * * [topPeerCategoryBotsPM#ab661b5b][TLTopPeerCategoryBotsPM]
 * * [topPeerCategoryChannels#161d9628][TLTopPeerCategoryChannels]
 * * [topPeerCategoryCorrespondents#637b7ed][TLTopPeerCategoryCorrespondents]
 * * [topPeerCategoryGroups#bd17a14a][TLTopPeerCategoryGroups]
 * * [topPeerCategoryPhoneCalls#1e76a78c][TLTopPeerCategoryPhoneCalls]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsTopPeerCategory : TLObject()
