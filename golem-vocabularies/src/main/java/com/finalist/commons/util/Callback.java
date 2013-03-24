package com.finalist.commons.util;

/**
 * @author Rob Schellhorn
 * @since 1.0
 *
 * @param <T>
 */
public interface Callback<T> {

    /**
     * @param obj
     */
    void execute(T obj);
}