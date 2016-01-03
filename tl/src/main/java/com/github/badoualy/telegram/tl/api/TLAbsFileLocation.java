
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public abstract class TLAbsFileLocation extends TLObject {

    protected long volumeId;

    protected int localId;

    protected long secret;


    public long getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(long value) {
        this.volumeId = value;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int value) {
        this.localId = value;
    }

    public long getSecret() {
        return secret;
    }

    public void setSecret(long value) {
        this.secret = value;
    }

}
