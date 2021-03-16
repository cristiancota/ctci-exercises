package leetCode.design;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Codec {

    Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        byte[] bytes = longUrl.getBytes(StandardCharsets.UTF_8);
        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        map.putIfAbsent(utf8EncodedString, longUrl);
        return utf8EncodedString;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}