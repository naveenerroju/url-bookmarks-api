package com.naveen.url_bookmarks.validator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class URLValidator {
    private static final String URL_REGEX =
            "^((http|https|ftp)://)?"
                    + "(([a-zA-Z0-9\\-\\._]+)\\.([a-zA-Z]{2,6}))" // Domain
                    + "(:\\d{1,5})?" // Port
                    + "(/[^\\s]*)?$"; // Path
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public static boolean isValidURL(String urlString) {
        try {
            new URL(urlString);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }


    public static boolean isValidURLUsingRegex(String urlString) {
        if (urlString == null) {
            return false;
        }
        return URL_PATTERN.matcher(urlString).matches();
    }

}
