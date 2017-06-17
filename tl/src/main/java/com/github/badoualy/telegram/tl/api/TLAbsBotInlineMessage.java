package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLBotInlineMessageMediaAuto}: botInlineMessageMediaAuto#a74b15b</li>
 * <li>{@link TLBotInlineMessageMediaContact}: botInlineMessageMediaContact#35edb4d4</li>
 * <li>{@link TLBotInlineMessageMediaGeo}: botInlineMessageMediaGeo#3a8fd8b8</li>
 * <li>{@link TLBotInlineMessageMediaVenue}: botInlineMessageMediaVenue#4366232e</li>
 * <li>{@link TLBotInlineMessageText}: botInlineMessageText#8c7f65e2</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsBotInlineMessage extends TLObject {

    protected int flags;

    protected TLAbsReplyMarkup replyMarkup;

    public TLAbsBotInlineMessage() {
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
