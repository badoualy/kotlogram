package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputDocumentEmpty extends TLAbsInputDocument {
    public static final int CLASS_ID = 0x72f0eaae;

    public TLInputDocumentEmpty() {
    }

    @Override
    public String toString() {
        return "inputDocumentEmpty#72f0eaae";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
