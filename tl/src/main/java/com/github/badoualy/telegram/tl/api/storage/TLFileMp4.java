
package com.github.badoualy.telegram.tl.api.storage;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLFileMp4 extends TLAbsFileType {
    public static final int CLASS_ID = 0xb3cea0e4;

    public TLFileMp4() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "storage.fileMp4#b3cea0e4";
    }

}
