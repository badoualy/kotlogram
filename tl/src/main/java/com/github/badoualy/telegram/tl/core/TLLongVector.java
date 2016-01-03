package com.github.badoualy.telegram.tl.core;

/**
 * TL Vector of longs. @see com.github.badoualy.telegram.tl.core.TLVector
 *
 * @author Korshakov Stepan <me@ex3ndr.com>
 */
public class TLLongVector extends TLVector<Long> {
    public TLLongVector() {
        setDestClass(Long.class);
    }

    @Override
    public String toString() {
        return "vector<long>#1cb5c415";
    }
}
