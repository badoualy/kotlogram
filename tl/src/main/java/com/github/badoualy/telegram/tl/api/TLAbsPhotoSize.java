
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsPhotoSize extends TLObject {

    protected String type;


    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

}
