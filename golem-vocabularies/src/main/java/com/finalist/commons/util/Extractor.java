package com.finalist.commons.util;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
public interface Extractor<S, T> {

    /**
     * @param obj
     * @return
     */
    T extract(S obj);
}