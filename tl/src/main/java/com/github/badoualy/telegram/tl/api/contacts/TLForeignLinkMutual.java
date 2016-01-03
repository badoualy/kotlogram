
package com.github.badoualy.telegram.tl.api.contacts;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLForeignLinkMutual extends TLAbsForeignLink {
    public static final int CLASS_ID = 0x1bea8ce1;

    public TLForeignLinkMutual() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "contacts.foreignLinkMutual#1bea8ce1";
    }

}
