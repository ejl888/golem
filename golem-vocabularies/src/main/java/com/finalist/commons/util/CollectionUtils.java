package com.finalist.commons.util;

import static com.google.common.collect.Sets.filter;
import static java.lang.String.format;
import static java.util.Collections.emptySet;
import static java.util.Collections.unmodifiableSet;
import static org.springframework.util.CollectionUtils.isEmpty;
import static org.springframework.util.StringUtils.hasText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Predicate;

/**
 * This utility class contains different methods for all {@link Collection} types.
 *
 * @author Rob Schellhorn
 * @since 1.0
 */
public final class CollectionUtils {

    public static <T> List<T> emptyListWhenNull(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public static <T> List<T> lazyInitOnAdd(List<T> list, T value) {
        final List<T> result = list == null ? new ArrayList<T>() : list;

        result.add(value);

        return result;
    }

    public static <T> List<T> lazyInitOnAddAll(List<T> list, Collection<T> values) {
        final List<T> result = list == null ? new ArrayList<T>(values.size()) : list;

        result.addAll(values);

        return result;
    }

    /**
     * Filters out elements without text (null, or whitespace only).
     *
     */
    public static Set<String> filterEmptyValues(Set<String> input) {
        return isEmpty(input) ? Collections.<String>emptySet() : filter(input, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return hasText(input);
            }
        });
    }
    
    /**
     * Add trimmed, non-empty values from the array to an unmodifiable list.
     * 
     */
    public static Set<String> filterEmptyValues(String[] values) {
        if (values == null || values.length < 1) {
            return emptySet();
        }

        Set<String> result = new HashSet<String>();
        for (String value : values) {
            if (hasText(value)) {
                result.add(value.trim());
            }
        }

        return unmodifiableSet(result);
    }

    /**
     * Limit the given list to a maximum number of items as
     * defined by <code>limit</code>. The items that are returned
     * are the first items in the list.
     *
     */
    public static <T> List<T> limitList(List<T> items, int limit) {
        if (items == null) {
            return null;
        }

        if (items.size() > limit) {
            return items.subList(0, limit);
        }

        return items;
    }
    
    /**
     * Expect to get maximum one element from this list. If the list is empty or <code>null</code> then
     * <code>null</code> is returned. If there is more than one element an {@link IllegalStateException}
     * is thrown.
     * 
     */
    public static <T> T onlyElement(List<T> items) {
        if (items == null || items.isEmpty()) {
            return null;
        } else if (items.size() > 1) {
            throw new IllegalStateException(
                    format("There is more than one element in the list: %s", items.toString()));
        }
        
        return items.get(0);
    }
    
    /**
     * Returns the first element in the set.
     * 
     * @param items
     * @return
     */
    public static <T> T first(Set<T> items) {
        if (isEmpty(items)) {
            return null;
        }
        return items.iterator().next();
    }
    

    private CollectionUtils() { /* utility class, do not instantiate */ }
}