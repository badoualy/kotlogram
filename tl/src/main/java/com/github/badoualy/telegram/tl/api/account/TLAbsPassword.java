
package com.github.badoualy.telegram.tl.api.account;


import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsPassword extends TLObject {

    protected TLBytes newSalt;

    protected String emailUnconfirmedPattern;


    public TLBytes getNewSalt() {
        return newSalt;
    }

    public void setNewSalt(TLBytes value) {
        this.newSalt = value;
    }

    public String getEmailUnconfirmedPattern() {
        return emailUnconfirmedPattern;
    }

    public void setEmailUnconfirmedPattern(String value) {
        this.emailUnconfirmedPattern = value;
    }

}
