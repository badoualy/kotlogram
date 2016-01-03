
package com.github.badoualy.telegram.tl.api.contacts;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLContactsNotModified extends TLAbsContacts {
    public static final int CLASS_ID = 0xb74ba9d2;

    public TLContactsNotModified() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "contacts.contactsNotModified#b74ba9d2";
    }

}
