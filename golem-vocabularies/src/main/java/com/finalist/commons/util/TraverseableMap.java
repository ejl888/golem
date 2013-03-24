package com.finalist.commons.util;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a 'fake' map that provides methods for easy traversing over values. 
 * 
 * @author arne
 *
 * @param <K> type of the keys
 * @param <V> type of the values
 */
public class TraverseableMap<K, V> {

    private final List<K> keys = new LinkedList<K>();
    private final List<V> values = new LinkedList<V>();
    
    public void put(K key, V value) {
        keys.add(key);
        values.add(value);
    }

    public V first() {
        return values.get(0);
    }
    
    public V get(K key) {
        return values.get(keys.indexOf(key));
    }
    
    public V previous(K key) {
        if (!hasPrevious(key)) {
            return null;
        }
        
        return values.get(keys.indexOf(key) - 1);
    }
    
    public boolean hasPrevious(K key) { 
        return keys.contains(key) && (keys.indexOf(key) - 1) >= 0;
    }
    
    public V next(K key) {
        if (!hasNext(key)) {
            return null;
        }
        
        return values.get(keys.indexOf(key) + 1);
    }
    
    public boolean hasNext(K key) { 
        return keys.contains(key) && (keys.indexOf(key) + 1) < keys.size();
    }
    
    public int indexOf(K key) {
        return keys.indexOf(key);
    }
    
    public int size() {
        return keys.size();
    }
}
