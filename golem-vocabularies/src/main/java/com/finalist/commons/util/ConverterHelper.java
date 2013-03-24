package com.finalist.commons.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Class to save some work writing converters. 
 * 
 * @author paul
 *
 * @param <S>
 * @param <T>
 */
public abstract class ConverterHelper<S, T> implements Converter<S, T> {
   
    public abstract T convert(S source);

    /**
     * @see Converter#convert(Collection)
     */
    public List<T> convert(Collection<S> objects) {
        if (objects == null) {
            return Collections.emptyList();
        }

        return convert(objects.iterator());
    }

    
    /**
     * @see Converter#convert(Iterator)
     */
    public List<T> convert(Iterator<S> iter) {
        if (iter == null) {
            return Collections.emptyList();
        }
        
        final List<T> result = new ArrayList<T>();
        while (iter.hasNext()) {
            T converted = convert(iter.next());
            if (converted != null) {
                result.add(converted);
            }
        }

        return result;
    }
}