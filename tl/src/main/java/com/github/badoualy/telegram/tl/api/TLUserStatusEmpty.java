
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUserStatusEmpty extends TLAbsUserStatus {
    public static final int CLASS_ID = 0x9d05049;

    public TLUserStatusEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "userStatusEmpty#9d05049";
    }

}
