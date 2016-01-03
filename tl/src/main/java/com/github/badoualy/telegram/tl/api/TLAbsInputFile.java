
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public abstract class TLAbsInputFile extends TLObject {

    protected long id;

    protected int parts;

    protected String name;


    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public int getParts() {
        return parts;
    }

    public void setParts(int value) {
        this.parts = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

}
