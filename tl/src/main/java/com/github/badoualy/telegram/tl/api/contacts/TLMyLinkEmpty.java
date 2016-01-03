
package com.github.badoualy.telegram.tl.api.contacts;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMyLinkEmpty extends TLAbsMyLink {
    public static final int CLASS_ID = 0xd22a1c60;

    public TLMyLinkEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "contacts.myLinkEmpty#d22a1c60";
    }

}
