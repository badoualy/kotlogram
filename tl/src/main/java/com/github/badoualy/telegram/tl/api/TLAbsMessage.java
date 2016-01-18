
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsMessage extends TLObject {

    protected int id;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

}
