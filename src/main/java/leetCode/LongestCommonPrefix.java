package leetCode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (prefix.length() == 0) {
                return "";
            }
            int j = 0;
            for (; j < Math.min(prefix.length(), strs[i].length()); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}
