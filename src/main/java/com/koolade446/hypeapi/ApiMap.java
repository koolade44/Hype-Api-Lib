package com.koolade446.hypeapi;

import java.util.*;

public class ApiMap implements Map<String, Object> {

    private Map<String, Object> map;

    public ApiMap(Map<String, Object> map) {
        this.map = map;
    }

    public boolean hasChildMap(String key) {
        if (map.get(key) instanceof Map) return true;
        return false;
    }

    public boolean hasChildList(String key) {
        if (map.get(key) instanceof List) return true;
        return false;
    }

    public ApiList getChildList(String key) throws IsNotListException {
        if (map.get(key) instanceof List) {
            return new ApiList((List<Object>) map.get(key));
        }
        else throw new IsNotListException("That is not a child list");
    }

    public Map<String, Object> getChildMap(String key) throws IsNotMapException {
        if (map.get(key) instanceof Map) return (Map<String, Object>) map.get(key);
        else throw new IsNotMapException("That is not a child map");
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return map.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set keySet() {
        return map.keySet();
    }

    @Override
    public Collection values() {
        return map.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return map.entrySet();
    }
}
