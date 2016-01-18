
package com.github.badoualy.telegram.tl.api;


public class TLSendMessageTypingAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0x16bf744e;

    public TLSendMessageTypingAction() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "sendMessageTypingAction#16bf744e";
    }

}
