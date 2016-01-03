
package com.github.badoualy.telegram.tl.api.help;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLNoAppUpdate extends TLAbsAppUpdate {
    public static final int CLASS_ID = 0xc45a6536;

    public TLNoAppUpdate() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "help.noAppUpdate#c45a6536";
    }

}
