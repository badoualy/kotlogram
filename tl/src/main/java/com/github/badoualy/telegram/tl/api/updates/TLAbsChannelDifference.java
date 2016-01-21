
package com.github.badoualy.telegram.tl.api.updates;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsChannelDifference extends TLObject {

    protected int flags;

    protected boolean fina;

    protected int pts;

    protected int timeout;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getFina() {
        return fina;
    }

    public void setFina(boolean value) {
        this.fina = value;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int value) {
        this.timeout = value;
    }

}
