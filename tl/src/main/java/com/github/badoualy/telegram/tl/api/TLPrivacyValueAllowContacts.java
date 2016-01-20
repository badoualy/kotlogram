
package com.github.badoualy.telegram.tl.api;


public class TLPrivacyValueAllowContacts extends TLAbsPrivacyRule {
    public static final int CLASS_ID = 0xfffe1bac;

    public TLPrivacyValueAllowContacts() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "privacyValueAllowContacts#fffe1bac";
    }

}
