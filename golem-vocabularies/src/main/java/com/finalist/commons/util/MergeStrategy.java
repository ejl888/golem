package com.finalist.commons.util;

/**
 * Strategy pattern for merging domain objects into entities.
 * 
 * @author arne
 * @since 1.0
 *
 */
public interface MergeStrategy<S, T> {

    /**
     * Merge the state of the source into the target entity.
     * 
     * @param source the source domain object
     * @param target the source target entity
     */
    T merge(S source, T target);
    
}
