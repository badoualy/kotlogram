
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsMessageEntity extends TLObject {

    protected int offset;

    protected int length;


    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int value) {
        this.length = value;
    }

}
