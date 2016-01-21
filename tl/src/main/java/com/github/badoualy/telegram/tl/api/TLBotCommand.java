
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLBotCommand extends TLObject {

    public static final int CLASS_ID = 0xc27ac8c7;

    public TLBotCommand() {

    }


    public TLBotCommand(        String _command,         String _description) {
        this.command = _command;
        this.description = _description;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String command;

    protected String description;


    public String getCommand() {
        return command;
    }

    public void setCommand(String value) {
        this.command = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.command, stream);
        writeTLString(this.description, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.command = readTLString(stream);
        this.description = readTLString(stream);
    }


    @Override
    public String toString() {
        return "botCommand#c27ac8c7";
    }

}
