
package com.github.badoualy.telegram.tl.api;


public class TLEncryptedFileEmpty extends TLAbsEncryptedFile {
    public static final int CLASS_ID = 0xc21f497e;

    public TLEncryptedFileEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "encryptedFileEmpty#c21f497e";
    }

}
