
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLDocumentAttributeFilename extends TLAbsDocumentAttribute {
    public static final int CLASS_ID = 0x15590068;

    public TLDocumentAttributeFilename() {

    }


    public TLDocumentAttributeFilename(        String _fileName) {
        this.fileName = _fileName;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String fileName;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String value) {
        this.fileName = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.fileName, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.fileName = readTLString(stream);
    }



    @Override
    public String toString() {
        return "documentAttributeFilename#15590068";
    }

}
