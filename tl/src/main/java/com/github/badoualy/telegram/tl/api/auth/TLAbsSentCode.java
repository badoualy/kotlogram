
package com.github.badoualy.telegram.tl.api.auth;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsSentCode extends TLObject {

    protected boolean phoneRegistered;

    protected String phoneCodeHash;

    protected int sendCallTimeout;

    protected boolean isPassword;


    public boolean getPhoneRegistered() {
        return phoneRegistered;
    }

    public void setPhoneRegistered(boolean value) {
        this.phoneRegistered = value;
    }

    public String getPhoneCodeHash() {
        return phoneCodeHash;
    }

    public void setPhoneCodeHash(String value) {
        this.phoneCodeHash = value;
    }

    public int getSendCallTimeout() {
        return sendCallTimeout;
    }

    public void setSendCallTimeout(int value) {
        this.sendCallTimeout = value;
    }

    public boolean getIsPassword() {
        return isPassword;
    }

    public void setIsPassword(boolean value) {
        this.isPassword = value;
    }

}
