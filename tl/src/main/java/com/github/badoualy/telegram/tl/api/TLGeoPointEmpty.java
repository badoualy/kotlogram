
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLGeoPointEmpty extends TLAbsGeoPoint {
    public static final int CLASS_ID = 0x1117dd5f;

    public TLGeoPointEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "geoPointEmpty#1117dd5f";
    }

}
