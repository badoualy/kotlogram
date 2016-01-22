package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageGeoLocationAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0x176f8ba1;

    public TLSendMessageGeoLocationAction() {
    }

    @Override
    public String toString() {
        return "sendMessageGeoLocationAction#176f8ba1";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
