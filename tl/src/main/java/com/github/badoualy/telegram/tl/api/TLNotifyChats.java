
package com.github.badoualy.telegram.tl.api;


public class TLNotifyChats extends TLAbsNotifyPeer {
    public static final int CLASS_ID = 0xc007cec3;

    public TLNotifyChats() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "notifyChats#c007cec3";
    }

}
