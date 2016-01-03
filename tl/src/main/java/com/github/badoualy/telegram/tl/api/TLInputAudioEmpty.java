
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputAudioEmpty extends TLAbsInputAudio {
    public static final int CLASS_ID = 0xd95adc84;

    public TLInputAudioEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputAudioEmpty#d95adc84";
    }

}
