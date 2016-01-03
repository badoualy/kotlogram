
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputEncryptedFileEmpty extends TLAbsInputEncryptedFile {
    public static final int CLASS_ID = 0x1837c364;

    public TLInputEncryptedFileEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputEncryptedFileEmpty#1837c364";
    }

}
