package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputFile;
import com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint;
import com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop;
import com.github.badoualy.telegram.tl.api.photos.TLPhoto;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestPhotosUploadProfilePhoto extends TLMethod<TLPhoto> {
    public static final int CLASS_ID = 0xd50f9c88;

    protected TLAbsInputFile file;

    protected String caption;

    protected TLAbsInputGeoPoint geoPoint;

    protected TLAbsInputPhotoCrop crop;

    public TLRequestPhotosUploadProfilePhoto() {
    }

    public TLRequestPhotosUploadProfilePhoto(TLAbsInputFile file, String caption, TLAbsInputGeoPoint geoPoint, TLAbsInputPhotoCrop crop) {
        this.file = file;
        this.caption = caption;
        this.geoPoint = geoPoint;
        this.crop = crop;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLPhoto deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLPhoto)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLPhoto) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(file, stream);
        writeTLString(caption, stream);
        writeTLObject(geoPoint, stream);
        writeTLObject(crop, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile) readTLObject(stream, context);
        caption = readTLString(stream);
        geoPoint = (com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint) readTLObject(stream, context);
        crop = (com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "photos.uploadProfilePhoto#d50f9c88";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputFile file) {
        this.file = file;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(TLAbsInputGeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public TLAbsInputPhotoCrop getCrop() {
        return crop;
    }

    public void setCrop(TLAbsInputPhotoCrop crop) {
        this.crop = crop;
    }
}
