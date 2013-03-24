package com.finalist.commons.util;

import java.util.List;

/**
 * A cache for storing objects, for example implemented by Ehcache.
 *
 */
public interface ObjectCache<K, V> {

    void put(V value);

    void putAll(List<V> values);

    V get(K key);
}
