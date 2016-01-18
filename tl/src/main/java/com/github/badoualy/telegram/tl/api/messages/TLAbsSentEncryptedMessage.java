
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsSentEncryptedMessage extends TLObject {

    protected int date;


    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

}
