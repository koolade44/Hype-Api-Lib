package com.koolade446.hypeapi;

import java.util.*;

public class ApiList implements List {

    List<Object> list;

    public ApiList (List<Object> list) {
        this.list = list;
    }

    public boolean hasChildMap(int index) {
        if (list.get(index) instanceof Map) return true;
        return false;
    }

    public boolean hasChildArray(int index) {
        if (list.get(index) instanceof List) return true;
        return false;
    }

    public ApiList getChildList(int index) throws IsNotListException {
        if (list.get(index) instanceof List) return new ApiList((List<Object>) list.get(index));
        else throw new IsNotListException("That is not a child array");
    }

    public Map<String, Object> getChildMap(int index) throws IsNotMapException {
        if (list.get(index) instanceof Map) return (Map<String, Object>) list.get(index);
        else throw new IsNotMapException("That is not a child map");
    }

    public Map<String, Object> searchForMapByKey(String key) {
        for (Object o : list) {
            if (o instanceof Map) {
                for (String k : ((Map<String, Object>) o).keySet()) {
                    if (k.equalsIgnoreCase(key)) return (Map<String, Object>) o;
                }
            }
        }
        return null;
    }

    public Map<String, Object> searchForMapByValue(Object value) {
        for (Object o : list) {
            if (o instanceof Map) {
                for (Object val : ((Map<String, Object>) o).values()) {
                    if (val instanceof String && value instanceof String) {
                        val = ((String) val).toLowerCase();
                        value = ((String) value).toLowerCase();
                    }
                    if (val.equals(value)) return (Map<String, Object>) o;
                }
            }
        }
        return null;
    }

    public Map<String, Object> searchForMapByKeyValue(String key, Object value) {
        for (Object o : list) {
            if (o instanceof Map) {
                for (String k : ((Map<String, Object>) o).keySet()) {
                    Object val = ((Map<String, Object>) o).get(k);
                    if (value instanceof String && val instanceof String) {
                        value = ((String) value).toLowerCase();
                        val = ((String) val).toLowerCase();
                    }
                    if (k.equalsIgnoreCase(key) && val.equals(((Map<String, Object>) o).get(key))) return (Map<String, Object>) o;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public boolean add(Object o) {
        return list.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return list.addAll(index, c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean equals(Object o) {
        return list.equals(o);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public Object get(int index) {
        return list.get(index);
    }

    @Override
    public Object set(int index, Object element) {
        return list.set(index, element);
    }

    @Override
    public void add(int index, Object element) {
        list.add(index, element);
    }

    @Override
    public Object remove(int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public boolean retainAll(Collection c) {
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return list.retainAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return list.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return list.toArray(a);
    }
}
