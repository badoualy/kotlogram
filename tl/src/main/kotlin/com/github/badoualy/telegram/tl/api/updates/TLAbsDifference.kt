package com.github.badoualy.telegram.tl.api.updates

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [updates.difference#f49ca0][TLDifference]
 * * [updates.differenceEmpty#5d75a138][TLDifferenceEmpty]
 * * [updates.differenceSlice#a8fb1981][TLDifferenceSlice]
 * * [updates.differenceTooLong#4afe8f6d][TLDifferenceTooLong]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsDifference : TLObject()
