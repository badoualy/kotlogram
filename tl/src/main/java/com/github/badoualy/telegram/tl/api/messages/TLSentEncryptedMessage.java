
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSentEncryptedMessage extends TLAbsSentEncryptedMessage {
    public static final int CLASS_ID = 0x560f8935;

    public TLSentEncryptedMessage() {

    }


    public TLSentEncryptedMessage(        int _date) {
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.date = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.sentEncryptedMessage#560f8935";
    }

}
