
package com.github.badoualy.telegram.tl.api;


public class TLPrivacyValueAllowAll extends TLAbsPrivacyRule {
    public static final int CLASS_ID = 0x65427b82;

    public TLPrivacyValueAllowAll() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "privacyValueAllowAll#65427b82";
    }

}
