
package com.github.badoualy.telegram.tl.api.storage;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLFilePartial extends TLAbsFileType {
    public static final int CLASS_ID = 0x40bc6f52;

    public TLFilePartial() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "storage.filePartial#40bc6f52";
    }

}
