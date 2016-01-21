
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsChannelParticipant extends TLObject {

    protected int userId;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

}
