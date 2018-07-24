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
 * * [inputMessagesFilterChatPhotos#3a20ecb8][TLInputMessagesFilterChatPhotos]
 * * [inputMessagesFilterContacts#e062db83][TLInputMessagesFilterContacts]
 * * [inputMessagesFilterDocument#9eddf188][TLInputMessagesFilterDocument]
 * * [inputMessagesFilterEmpty#57e2f66c][TLInputMessagesFilterEmpty]
 * * [inputMessagesFilterGeo#e7026d0d][TLInputMessagesFilterGeo]
 * * [inputMessagesFilterGif#ffc86587][TLInputMessagesFilterGif]
 * * [inputMessagesFilterMusic#3751b49e][TLInputMessagesFilterMusic]
 * * [inputMessagesFilterMyMentions#c1f8e69a][TLInputMessagesFilterMyMentions]
 * * [inputMessagesFilterPhoneCalls#80c99768][TLInputMessagesFilterPhoneCalls]
 * * [inputMessagesFilterPhotoVideo#56e9f0e4][TLInputMessagesFilterPhotoVideo]
 * * [inputMessagesFilterPhotos#9609a51c][TLInputMessagesFilterPhotos]
 * * [inputMessagesFilterRoundVideo#b549da53][TLInputMessagesFilterRoundVideo]
 * * [inputMessagesFilterRoundVoice#7a7c17a4][TLInputMessagesFilterRoundVoice]
 * * [inputMessagesFilterUrl#7ef0dd87][TLInputMessagesFilterUrl]
 * * [inputMessagesFilterVideo#9fc00e65][TLInputMessagesFilterVideo]
 * * [inputMessagesFilterVoice#50f5c392][TLInputMessagesFilterVoice]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessagesFilter : TLObject()
