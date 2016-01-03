
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputDocumentEmpty extends TLAbsInputDocument {
    public static final int CLASS_ID = 0x72f0eaae;

    public TLInputDocumentEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputDocumentEmpty#72f0eaae";
    }

}
