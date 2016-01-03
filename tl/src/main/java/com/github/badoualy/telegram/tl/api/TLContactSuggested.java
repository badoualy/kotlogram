
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLContactSuggested extends TLObject {

    public static final int CLASS_ID = 0x3de191a1;

    public TLContactSuggested() {

    }


    public TLContactSuggested(        int _userId,         int _mutualContacts) {
        this.userId = _userId;
        this.mutualContacts = _mutualContacts;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected int mutualContacts;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getMutualContacts() {
        return mutualContacts;
    }

    public void setMutualContacts(int value) {
        this.mutualContacts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeInt(this.mutualContacts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.mutualContacts = readInt(stream);
    }


    @Override
    public String toString() {
        return "contactSuggested#3de191a1";
    }

}
