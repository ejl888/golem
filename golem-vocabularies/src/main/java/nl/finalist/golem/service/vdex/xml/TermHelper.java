package nl.finalist.golem.service.vdex.xml;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class TermHelper {

    private TermHelper() {}

    public static String toSearchIdentifier(final String identifier) {
        return toSearchIdentifier(identifier, true);
    }

    public static String toSearchIdentifier(final String identifier, boolean lowerCase) {
        String result = identifier;
        try {
            result = URLDecoder.decode(result, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(System.err);
        }
        if (lowerCase) {
            result = result.toLowerCase();
        }
        return result;
    }



    public static String encodeIdentifier(final String identifier) {
        try {
            return URLEncoder.encode(identifier, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(System.err);
        }
        return identifier;
    }

}
