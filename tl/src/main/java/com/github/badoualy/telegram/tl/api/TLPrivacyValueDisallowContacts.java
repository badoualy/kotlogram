
package com.github.badoualy.telegram.tl.api;


public class TLPrivacyValueDisallowContacts extends TLAbsPrivacyRule {
    public static final int CLASS_ID = 0xf888fa1a;

    public TLPrivacyValueDisallowContacts() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "privacyValueDisallowContacts#f888fa1a";
    }

}
