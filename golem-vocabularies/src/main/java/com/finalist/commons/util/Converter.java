package com.finalist.commons.util;

import java.util.Collection;
import java.util.List;

/**
 * Converts objects from one type to another.
 * Mainly used to convert from persistence to transfer object and back. 
 * 
 * @author paul
 *
 * @param <S> the source
 * @param <T> the target
 */
public interface Converter<S, T> {
   
    T convert(S source);
    
    /**
     * Converts a collection of objects to a list of other objects using this classes convert method.
     * Returns an empty list of the input Collection is null.
     * 
     * @param sourceCollection
     * @return
     */
    List<T> convert(Collection<S> sourceCollection);
}