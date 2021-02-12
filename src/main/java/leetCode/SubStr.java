package leetCode;

public class SubStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (haystackLength < needleLength) {
            return -1;
        }

        for (int i = 0; i <= haystackLength - needleLength; i++) {
            String sub = haystack.substring(i, needleLength + i);
            if (sub.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
