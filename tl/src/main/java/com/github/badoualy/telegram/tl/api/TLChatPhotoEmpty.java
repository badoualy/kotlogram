package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatPhotoEmpty extends TLAbsChatPhoto {
    public static final int CLASS_ID = 0x37c1011c;

    public TLChatPhotoEmpty() {
    }

    @Override
    public String toString() {
        return "chatPhotoEmpty#37c1011c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
