
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public abstract class TLAbsDhConfig extends TLObject {

    protected TLBytes random;


    public TLBytes getRandom() {
        return random;
    }

    public void setRandom(TLBytes value) {
        this.random = value;
    }

}
