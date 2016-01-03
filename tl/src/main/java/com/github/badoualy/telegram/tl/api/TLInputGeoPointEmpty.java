
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputGeoPointEmpty extends TLAbsInputGeoPoint {
    public static final int CLASS_ID = 0xe4c123d6;

    public TLInputGeoPointEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputGeoPointEmpty#e4c123d6";
    }

}
