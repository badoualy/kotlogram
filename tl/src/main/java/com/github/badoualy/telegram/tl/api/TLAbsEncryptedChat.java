package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLEncryptedChat}: encryptedChat#fa56ce36</li>
 * <li>{@link TLEncryptedChatDiscarded}: encryptedChatDiscarded#13d6dd27</li>
 * <li>{@link TLEncryptedChatEmpty}: encryptedChatEmpty#ab7ec0a0</li>
 * <li>{@link TLEncryptedChatRequested}: encryptedChatRequested#c878527e</li>
 * <li>{@link TLEncryptedChatWaiting}: encryptedChatWaiting#3bf703dc</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsEncryptedChat extends TLObject {

    protected int id;

    public TLAbsEncryptedChat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
