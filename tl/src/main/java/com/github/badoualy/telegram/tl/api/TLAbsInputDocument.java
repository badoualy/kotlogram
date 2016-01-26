package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputDocument extends TLObject {
    public TLAbsInputDocument() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLInputDocument getAsInputDocument() {
        return null;
    }

    public static TLInputDocumentEmpty newEmpty() {
        return new TLInputDocumentEmpty();
    }

    public static TLInputDocument newNotEmpty() {
        return new TLInputDocument();
    }
}
