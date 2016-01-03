
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public abstract class TLAbsSentEncryptedMessage extends TLObject {

    protected int date;


    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

}
