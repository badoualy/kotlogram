
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public abstract class TLAbsEncryptedMessage extends TLObject {

    protected long randomId;

    protected int chatId;

    protected int date;

    protected TLBytes bytes;


    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes value) {
        this.bytes = value;
    }

}
