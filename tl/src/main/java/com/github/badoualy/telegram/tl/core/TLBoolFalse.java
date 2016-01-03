package com.github.badoualy.telegram.tl.core;

/**
 * Packed type of tl-bool false value
 *
 * @author Korshakov Stepan <me@ex3ndr.com>
 */
public class TLBoolFalse extends TLBool {

    public static final int CLASS_ID = 0xbc799737;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "boolFalse#bc799737";
    }
}
