
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputMediaEmpty extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x9664f57f;

    public TLInputMediaEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputMediaEmpty#9664f57f";
    }

}
