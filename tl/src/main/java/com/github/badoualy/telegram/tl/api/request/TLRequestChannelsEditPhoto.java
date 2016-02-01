package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestChannelsEditPhoto extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0xf12e57c9;

    protected TLAbsInputChannel channel;

    protected TLAbsInputChatPhoto photo;

    public TLRequestChannelsEditPhoto() {
    }

    public TLRequestChannelsEditPhoto(TLAbsInputChannel channel, TLAbsInputChatPhoto photo) {
        this.channel = channel;
        this.photo = photo;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(channel, stream);
        writeTLObject(photo, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channel = (com.github.badoualy.telegram.tl.api.TLAbsInputChannel) readTLObject(stream, context);
        photo = (com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "channels.editPhoto#f12e57c9";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public TLAbsInputChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsInputChatPhoto photo) {
        this.photo = photo;
    }
}
