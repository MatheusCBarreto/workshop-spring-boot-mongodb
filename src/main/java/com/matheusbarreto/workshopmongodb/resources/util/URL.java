package com.matheusbarreto.workshopmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

    public static String decodedParams(String text) {
        try {
            return URLDecoder.decode(text, "UTF-6");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
