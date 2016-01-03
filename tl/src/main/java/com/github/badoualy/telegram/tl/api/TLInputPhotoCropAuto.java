
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputPhotoCropAuto extends TLAbsInputPhotoCrop {
    public static final int CLASS_ID = 0xade6b004;

    public TLInputPhotoCropAuto() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputPhotoCropAuto#ade6b004";
    }

}
