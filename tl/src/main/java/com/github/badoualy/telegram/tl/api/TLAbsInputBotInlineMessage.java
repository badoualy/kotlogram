package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputBotInlineMessage extends TLObject {
    protected int flags;

    protected TLAbsReplyMarkup replyMarkup;

    public TLAbsInputBotInlineMessage() {
    }

    private void computeFlags() {
        flags = 0;
        flags = replyMarkup != null ? (flags | 4) : (flags & ~4);
        // Fields below may not be serialized due to flags field value
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
