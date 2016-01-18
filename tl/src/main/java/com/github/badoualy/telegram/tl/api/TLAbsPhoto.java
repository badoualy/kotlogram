
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsPhoto extends TLObject {

    protected long id;


    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

}
