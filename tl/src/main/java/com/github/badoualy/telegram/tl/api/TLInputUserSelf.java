
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputUserSelf extends TLAbsInputUser {
    public static final int CLASS_ID = 0xf7c1b13f;

    public TLInputUserSelf() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputUserSelf#f7c1b13f";
    }

}
