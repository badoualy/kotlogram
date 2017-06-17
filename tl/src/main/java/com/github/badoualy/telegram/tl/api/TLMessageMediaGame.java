package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaGame extends TLAbsMessageMedia {

    public static final int CONSTRUCTOR_ID = 0xfdb19008;

    protected TLGame game;

    private final String _constructor = "messageMediaGame#fdb19008";

    public TLMessageMediaGame() {
    }

    public TLMessageMediaGame(TLGame game) {
        this.game = game;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(game, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        game = readTLObject(stream, context, TLGame.class, TLGame.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += game.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLGame getGame() {
        return game;
    }

    public void setGame(TLGame game) {
        this.game = game;
    }
}
