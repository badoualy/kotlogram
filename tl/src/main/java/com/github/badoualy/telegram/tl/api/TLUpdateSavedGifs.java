
package com.github.badoualy.telegram.tl.api;


public class TLUpdateSavedGifs extends TLAbsUpdate {
    public static final int CLASS_ID = 0x9375341e;

    public TLUpdateSavedGifs() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "updateSavedGifs#9375341e";
    }

}
