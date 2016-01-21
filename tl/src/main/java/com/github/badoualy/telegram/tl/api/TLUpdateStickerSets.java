
package com.github.badoualy.telegram.tl.api;


public class TLUpdateStickerSets extends TLAbsUpdate {
    public static final int CLASS_ID = 0x43ae3dec;

    public TLUpdateStickerSets() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "updateStickerSets#43ae3dec";
    }

}
