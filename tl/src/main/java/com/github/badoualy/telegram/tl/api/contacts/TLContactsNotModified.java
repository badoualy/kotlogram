package com.github.badoualy.telegram.tl.api.contacts;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContactsNotModified extends TLAbsContacts {

    public static final int CONSTRUCTOR_ID = 0xb74ba9d2;

    private final String _constructor = "contacts.contactsNotModified#b74ba9d2";

    public TLContactsNotModified() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
