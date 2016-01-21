
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsReplyMarkup extends TLObject {

    protected int flags;

    protected boolean selective;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getSelective() {
        return selective;
    }

    public void setSelective(boolean value) {
        this.selective = value;
    }

}
