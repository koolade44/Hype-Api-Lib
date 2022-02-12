package com.koolade446.hypeapi;

public class ParsedValue {
    Object val;
    boolean parseSuccessful;

    public ParsedValue(Object val, boolean parseSuccessful) {
        this.val = val;
        this.parseSuccessful = parseSuccessful;
    }

    public Class<?> getType() {
        return val.getClass();
    }

    public Object getValue() {
        return val;
    }

    public boolean typeEquals(Class<?> c) {
        if (val.getClass().equals(c)) return true;
        return false;
    }

    public boolean isParseSuccessful() {
        return parseSuccessful;
    }
}
