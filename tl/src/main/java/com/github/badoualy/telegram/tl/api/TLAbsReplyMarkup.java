package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLReplyInlineMarkup}: replyInlineMarkup#48a30254</li>
 * <li>{@link TLReplyKeyboardForceReply}: replyKeyboardForceReply#f4108aa0</li>
 * <li>{@link TLReplyKeyboardHide}: replyKeyboardHide#a03e5b85</li>
 * <li>{@link TLReplyKeyboardMarkup}: replyKeyboardMarkup#3502758c</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsReplyMarkup extends TLObject {

    public TLAbsReplyMarkup() {
    }
}
