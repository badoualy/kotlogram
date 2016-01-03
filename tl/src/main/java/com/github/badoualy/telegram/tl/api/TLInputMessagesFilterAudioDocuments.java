
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputMessagesFilterAudioDocuments extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0x5afbf764;

    public TLInputMessagesFilterAudioDocuments() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputMessagesFilterAudioDocuments#5afbf764";
    }

}
