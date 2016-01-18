
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLWallPaperSolid extends TLAbsWallPaper {
    public static final int CLASS_ID = 0x63117f24;

    public TLWallPaperSolid() {

    }


    public TLWallPaperSolid(        int _id,         String _title,         int _bgColor,         int _color) {
        this.id = _id;
        this.title = _title;
        this.bgColor = _bgColor;
        this.color = _color;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int bgColor;


    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int value) {
        this.bgColor = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeInt(this.bgColor, stream);
        writeInt(this.color, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.title = readTLString(stream);
        this.bgColor = readInt(stream);
        this.color = readInt(stream);
    }



    @Override
    public String toString() {
        return "wallPaperSolid#63117f24";
    }

}
