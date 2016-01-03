
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
