package com.finalist.commons.util;

import java.util.*;

public final class MapUtils {

    private MapUtils() {
    }
    
    public static <T, S> Set<S> getAllValues(Map<T, List<S>> map) {
        if (map == null) {
            return Collections.emptySet();
        }
        Set<S> result = new HashSet<S>();
        for (List<S> values : map.values()) {
            if (values != null) {
                result.addAll(values);
            }
        }
        return result;
    }

    public static <T, S> void addToMap(T key, S element, Map<T, List<S>> map) {
        if (map == null) {
            throw new IllegalArgumentException("cannot add element to a nonexisting map");
        }
        if (map.get(key) == null) {
            map.put(key, new ArrayList<S>());
        }
        map.get(key).add(element);
    }

    public static <T, S> void addAllToMap(T key, Collection<S> elements, Map<T, List<S>> map) {
        if (map == null) {
            throw new IllegalArgumentException("cannot add element to a nonexisting map");
        }
        if (elements != null) {
            if (map.get(key) == null) {
                map.put(key, new ArrayList<S>());
            }
            map.get(key).addAll(elements);
        }
    }

}
