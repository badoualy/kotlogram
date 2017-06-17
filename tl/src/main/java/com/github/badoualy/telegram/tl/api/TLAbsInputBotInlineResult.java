package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputBotInlineResult}: inputBotInlineResult#2cbbe15a</li>
 * <li>{@link TLInputBotInlineResultDocument}: inputBotInlineResultDocument#fff8fdc4</li>
 * <li>{@link TLInputBotInlineResultGame}: inputBotInlineResultGame#4fa417f2</li>
 * <li>{@link TLInputBotInlineResultPhoto}: inputBotInlineResultPhoto#a8d864a7</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputBotInlineResult extends TLObject {

    protected String id;

    protected TLAbsInputBotInlineMessage sendMessage;

    public TLAbsInputBotInlineResult() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TLAbsInputBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsInputBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
