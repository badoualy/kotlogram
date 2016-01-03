
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public abstract class TLAbsAudio extends TLObject {

    protected long id;


    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

}
