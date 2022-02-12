package com.koolade446.hypeapi;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class ApiUtils {

    private static Map<Class<?>, Predicate<String>> parsable = new HashMap<>();

    static {
        parsable.put(Boolean.TYPE, s -> {if (s.equalsIgnoreCase("true")) {return true;}else{return false;}});
        parsable.put(Integer.TYPE, s -> {try{Integer.parseInt(s); return true;}catch(Exception e){return false;}});
        parsable.put(Float.TYPE, s -> {try{Float.parseFloat(s); return true;}catch(Exception e) {return false;}});
        parsable.put(Long.TYPE, s -> {try{Long.parseLong(s); return true;}catch(Exception e) {return false;}});
        parsable.put(Double.TYPE, s -> {try{Double.parseDouble(s); return true;}catch(Exception e) {return false;}});
    }

    public static ParsedValue tryParseAsBoolean(String value) {
        if (parsable.get(Boolean.TYPE).test(value)) {
            return new ParsedValue(Boolean.parseBoolean(value), true);
        }
        return new ParsedValue(value, false);
    }

    public static ParsedValue tryParseAsInt(String value) {
        if (parsable.get(Integer.TYPE).test(value)) {
            return new ParsedValue(Integer.parseInt(value), true);
        }
        return new ParsedValue(value, false);
    }

    public static ParsedValue tryParseAsFloat(String value) {
        if (parsable.get(Float.TYPE).test(value)) {
            return new ParsedValue(Float.parseFloat(value), true);
        }
        return new ParsedValue(value, false);
    }

    public static ParsedValue tryParseAsLong(String value) {
        if (parsable.get(Long.TYPE).test(value)) {
            return new ParsedValue(Long.parseLong(value), true);
        }
        return new ParsedValue(value, false);
    }

    public static ParsedValue tryParseAsDouble(String value) {
        if (parsable.get(Long.TYPE).test(value)) {
            return new ParsedValue(Long.parseLong(value), true);
        }
        return new ParsedValue(value, false);
    }

    public static ParsedValue tryParseAll(String value) {
        if (parsable.get(Boolean.TYPE).test(value)) return new ParsedValue(Boolean.parseBoolean(value), true);
        else if (parsable.get(Integer.TYPE).test(value)) return new ParsedValue(Integer.parseInt(value), true);
        else if (parsable.get(Float.TYPE).test(value)) return new ParsedValue(Float.parseFloat(value), true);
        else if (parsable.get(Double.TYPE).test(value)) return new ParsedValue(Double.parseDouble(value), true);
        else if (parsable.get(Long.TYPE).test(value)) return new ParsedValue(Long.parseLong(value), true);
        return new ParsedValue(value, false);
    }
}
