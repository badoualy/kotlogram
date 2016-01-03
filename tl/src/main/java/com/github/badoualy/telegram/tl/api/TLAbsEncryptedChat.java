
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public abstract class TLAbsEncryptedChat extends TLObject {

    protected int id;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

}
