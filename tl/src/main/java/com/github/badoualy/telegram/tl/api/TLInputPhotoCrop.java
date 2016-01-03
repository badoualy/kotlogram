
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputPhotoCrop extends TLAbsInputPhotoCrop {
    public static final int CLASS_ID = 0xd9915325;

    public TLInputPhotoCrop() {

    }


    public TLInputPhotoCrop(        double _cropLeft,         double _cropTop,         double _cropWidth) {
        this.cropLeft = _cropLeft;
        this.cropTop = _cropTop;
        this.cropWidth = _cropWidth;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected double cropLeft;

    protected double cropTop;

    protected double cropWidth;


    public double getCropLeft() {
        return cropLeft;
    }

    public void setCropLeft(double value) {
        this.cropLeft = value;
    }

    public double getCropTop() {
        return cropTop;
    }

    public void setCropTop(double value) {
        this.cropTop = value;
    }

    public double getCropWidth() {
        return cropWidth;
    }

    public void setCropWidth(double value) {
        this.cropWidth = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeDouble(this.cropLeft, stream);
        writeDouble(this.cropTop, stream);
        writeDouble(this.cropWidth, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.cropLeft = readDouble(stream);
        this.cropTop = readDouble(stream);
        this.cropWidth = readDouble(stream);
    }



    @Override
    public String toString() {
        return "inputPhotoCrop#d9915325";
    }

}
