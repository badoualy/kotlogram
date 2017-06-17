package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputBotInlineMessageGame}: inputBotInlineMessageGame#4b425864</li>
 * <li>{@link TLInputBotInlineMessageMediaAuto}: inputBotInlineMessageMediaAuto#292fed13</li>
 * <li>{@link TLInputBotInlineMessageMediaContact}: inputBotInlineMessageMediaContact#2daf01a7</li>
 * <li>{@link TLInputBotInlineMessageMediaGeo}: inputBotInlineMessageMediaGeo#f4a59de1</li>
 * <li>{@link TLInputBotInlineMessageMediaVenue}: inputBotInlineMessageMediaVenue#aaafadc8</li>
 * <li>{@link TLInputBotInlineMessageText}: inputBotInlineMessageText#3dcd7a87</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputBotInlineMessage extends TLObject {

    protected int flags;

    protected TLAbsReplyMarkup replyMarkup;

    public TLAbsInputBotInlineMessage() {
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
