
package com.github.badoualy.telegram.tl.api.storage;


public class TLFileUnknown extends TLAbsFileType {
    public static final int CLASS_ID = 0xaa963b05;

    public TLFileUnknown() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "storage.fileUnknown#aa963b05";
    }

}
