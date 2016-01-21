
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestMessagesGetDocumentByHash extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsDocument> {

    public static final int CLASS_ID = 0x338e2464;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetDocumentByHash(        TLBytes _sha256,         int _size,         String _mimeType) {
        this.sha256 = _sha256;
        this.size = _size;
        this.mimeType = _mimeType;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsDocument deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsDocument) {
            return (com.github.badoualy.telegram.tl.api.TLAbsDocument)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsDocument, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected TLBytes sha256;

    protected int size;

    protected String mimeType;


    public TLBytes getSha256() {
        return sha256;
    }

    public void setSha256(TLBytes value) {
        this.sha256 = value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int value) {
        this.size = value;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String value) {
        this.mimeType = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBytes(this.sha256, stream);
        writeInt(this.size, stream);
        writeTLString(this.mimeType, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.sha256 = readTLBytes(stream, context);
        this.size = readInt(stream);
        this.mimeType = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messages.getDocumentByHash#338e2464";
    }

}
