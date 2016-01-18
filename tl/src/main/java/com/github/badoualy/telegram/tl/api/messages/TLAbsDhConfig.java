
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsDhConfig extends TLObject {

    protected TLBytes random;


    public TLBytes getRandom() {
        return random;
    }

    public void setRandom(TLBytes value) {
        this.random = value;
    }

}
