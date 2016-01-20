
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;


public class TLPrivacyKey extends TLObject {

    public static final int CLASS_ID = 0xbc2eab30;

    public TLPrivacyKey() {

    }



    public int getClassId() {
        return CLASS_ID;
    }






    @Override
    public String toString() {
        return "privacyKeyStatusTimestamp#bc2eab30";
    }

}
