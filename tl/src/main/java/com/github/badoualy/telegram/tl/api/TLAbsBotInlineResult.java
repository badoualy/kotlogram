
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsBotInlineResult extends TLObject {

    protected String id;

    protected String type;

    protected com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage sendMessage;


    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage value) {
        this.sendMessage = value;
    }

}
