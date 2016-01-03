
package com.github.badoualy.telegram.tl.api.contacts;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLForeignLinkRequested extends TLAbsForeignLink {
    public static final int CLASS_ID = 0xa7801f47;

    public TLForeignLinkRequested() {

    }


    public TLForeignLinkRequested(        boolean _hasPhone) {
        this.hasPhone = _hasPhone;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected boolean hasPhone;


    public boolean getHasPhone() {
        return hasPhone;
    }

    public void setHasPhone(boolean value) {
        this.hasPhone = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBool(this.hasPhone, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.hasPhone = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "contacts.foreignLinkRequested#a7801f47";
    }

}
