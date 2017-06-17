package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputMessageEntityMentionName}: inputMessageEntityMentionName#208e68c9</li>
 * <li>{@link TLMessageEntityBold}: messageEntityBold#bd610bc9</li>
 * <li>{@link TLMessageEntityBotCommand}: messageEntityBotCommand#6cef8ac7</li>
 * <li>{@link TLMessageEntityCode}: messageEntityCode#28a20571</li>
 * <li>{@link TLMessageEntityEmail}: messageEntityEmail#64e475c2</li>
 * <li>{@link TLMessageEntityHashtag}: messageEntityHashtag#6f635b0d</li>
 * <li>{@link TLMessageEntityItalic}: messageEntityItalic#826f8b60</li>
 * <li>{@link TLMessageEntityMention}: messageEntityMention#fa04579d</li>
 * <li>{@link TLMessageEntityMentionName}: messageEntityMentionName#352dca58</li>
 * <li>{@link TLMessageEntityPre}: messageEntityPre#73924be0</li>
 * <li>{@link TLMessageEntityTextUrl}: messageEntityTextUrl#76a6d327</li>
 * <li>{@link TLMessageEntityUnknown}: messageEntityUnknown#bb92ba95</li>
 * <li>{@link TLMessageEntityUrl}: messageEntityUrl#6ed02538</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsMessageEntity extends TLObject {

    protected int offset;

    protected int length;

    public TLAbsMessageEntity() {
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
