package com.github.badoualy.telegram.tl.core;

/**
 * TL Vector of strings. @see com.github.badoualy.telegram.tl.core.TLVector
 *
 * @author Korshakov Stepan me@ex3ndr.com
 */
public class TLStringVector extends TLVector<String> {
    public TLStringVector() {
        setDestClass(String.class);
    }

    @Override
    public String toString() {
        return "vector<string>#1cb5c415";
    }
}
