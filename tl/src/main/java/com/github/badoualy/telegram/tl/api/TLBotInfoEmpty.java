
package com.github.badoualy.telegram.tl.api;


public class TLBotInfoEmpty extends TLAbsBotInfo {
    public static final int CLASS_ID = 0xbb2e37ce;

    public TLBotInfoEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "botInfoEmpty#bb2e37ce";
    }

}
