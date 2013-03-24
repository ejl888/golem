package com.finalist.commons.util;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

/**
 * @author Rob Schellhorn
 * @since 1.0
 */
public final class StringUtils {

    public static List<String> filterEmptyValues(String... values) {
        return filterEmptyValues(Lists.newArrayList(values));
    }
    
    public static List<String> filterEmptyValues(List<String> values) {
        List<String> result = Lists.newArrayListWithCapacity(values.size());
        for (String value : values) {
            if (hasText(value)) {
                result.add(value);
            }
        }

        return result;
    }
    
    public static boolean containsAny(String source, Collection<String> values) {
        for (String value : values) {
            if (source.contains(value)) {
                return true;
            }
        }

        return false;
    }
    
    public static String concatenate(String... values) {
        return org.apache.commons.lang3.StringUtils.join(values);
    }

    private StringUtils() { /* Util class, do not instantiate */ }
}