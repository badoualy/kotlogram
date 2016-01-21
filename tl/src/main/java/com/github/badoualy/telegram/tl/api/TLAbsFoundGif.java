
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsFoundGif extends TLObject {

    protected String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

}
