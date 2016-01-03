
package com.github.badoualy.telegram.tl.api.contacts;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMyLinkContact extends TLAbsMyLink {
    public static final int CLASS_ID = 0xc240ebd9;

    public TLMyLinkContact() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "contacts.myLinkContact#c240ebd9";
    }

}
