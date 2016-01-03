
package com.github.badoualy.telegram.tl.api.contacts;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLForeignLinkUnknown extends TLAbsForeignLink {
    public static final int CLASS_ID = 0x133421f8;

    public TLForeignLinkUnknown() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "contacts.foreignLinkUnknown#133421f8";
    }

}
