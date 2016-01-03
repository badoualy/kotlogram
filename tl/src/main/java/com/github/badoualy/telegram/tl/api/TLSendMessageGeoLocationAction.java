
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSendMessageGeoLocationAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0x176f8ba1;

    public TLSendMessageGeoLocationAction() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "sendMessageGeoLocationAction#176f8ba1";
    }

}
