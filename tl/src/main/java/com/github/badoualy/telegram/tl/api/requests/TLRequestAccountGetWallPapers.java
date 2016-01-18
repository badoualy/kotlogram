
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;


public class TLRequestAccountGetWallPapers extends TLMethod<com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsWallPaper>> {

    public static final int CLASS_ID = 0xc04cfac2;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountGetWallPapers() {

    }



    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsWallPaper> deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return readTLVector(stream, context);

    }
        







    @Override
    public String toString() {
        return "account.getWallPapers#c04cfac2";
    }

}
