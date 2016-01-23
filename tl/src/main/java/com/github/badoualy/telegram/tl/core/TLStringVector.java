package com.github.badoualy.telegram.tl.core;

public class TLStringVector extends TLVector<String> {
    public TLStringVector() {
        setDestClass(String.class);
    }

    @Override
    public String toString() {
        return "vector<string>#1cb5c415";
    }
}
