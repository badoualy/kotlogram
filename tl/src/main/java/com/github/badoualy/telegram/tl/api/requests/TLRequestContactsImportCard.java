
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestContactsImportCard extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUser> {

    public static final int CLASS_ID = 0x4fe196fe;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestContactsImportCard(        com.github.badoualy.telegram.tl.core.TLIntVector _exportCard) {
        this.exportCard = _exportCard;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsUser deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsUser) {
            return (com.github.badoualy.telegram.tl.api.TLAbsUser)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsUser, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.core.TLIntVector exportCard;


    public com.github.badoualy.telegram.tl.core.TLIntVector getExportCard() {
        return exportCard;
    }

    public void setExportCard(com.github.badoualy.telegram.tl.core.TLIntVector value) {
        this.exportCard = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.exportCard, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.exportCard = readTLIntVector(stream, context);
    }



    @Override
    public String toString() {
        return "contacts.importCard#4fe196fe";
    }

}
