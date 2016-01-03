
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestUsersGetUsers extends TLMethod<com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser>> {

    public static final int CLASS_ID = 0xd91a548;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestUsersGetUsers(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> _id) {
        this.id = _id;

    }



    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return readTLVector(stream, context);

    }
        


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> id;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "users.getUsers#d91a548";
    }

}
