package com.github.badoualy.telegram.tl.api.contacts;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContactsNotModified extends TLAbsContacts {
    public static final int CLASS_ID = 0xb74ba9d2;

    public TLContactsNotModified() {
    }

    @Override
    public String toString() {
        return "contacts.contactsNotModified#b74ba9d2";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
