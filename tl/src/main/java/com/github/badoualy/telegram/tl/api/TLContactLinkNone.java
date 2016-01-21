
package com.github.badoualy.telegram.tl.api;


public class TLContactLinkNone extends TLAbsContactLink {
    public static final int CLASS_ID = 0xfeedd3ad;

    public TLContactLinkNone() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "contactLinkNone#feedd3ad";
    }

}
