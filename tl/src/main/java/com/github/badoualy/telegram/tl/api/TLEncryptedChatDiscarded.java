
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLEncryptedChatDiscarded extends TLAbsEncryptedChat {
    public static final int CLASS_ID = 0x13d6dd27;

    public TLEncryptedChatDiscarded() {

    }


    public TLEncryptedChatDiscarded(        int _id) {
        this.id = _id;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
    }



    @Override
    public String toString() {
        return "encryptedChatDiscarded#13d6dd27";
    }

}
