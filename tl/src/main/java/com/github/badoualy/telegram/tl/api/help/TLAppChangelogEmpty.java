package com.github.badoualy.telegram.tl.api.help;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAppChangelogEmpty extends TLAbsAppChangelog {
    public static final int CONSTRUCTOR_ID = 0xaf7e0394;

    private final String _constructor = "help.appChangelogEmpty#af7e0394";

    public TLAppChangelogEmpty() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
