
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLEncryptedFileEmpty extends TLAbsEncryptedFile {
    public static final int CLASS_ID = 0xc21f497e;

    public TLEncryptedFileEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "encryptedFileEmpty#c21f497e";
    }

}
