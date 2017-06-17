package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLBotInlineMediaResult}: botInlineMediaResult#17db940b</li>
 * <li>{@link TLBotInlineResult}: botInlineResult#9bebaeb9</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsBotInlineResult extends TLObject {

    protected int flags;

    protected String id;

    protected String type;

    protected TLAbsBotInlineMessage sendMessage;

    public TLAbsBotInlineResult() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TLAbsBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
