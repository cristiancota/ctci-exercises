package leetCode;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return getFinalString(S).equals(getFinalString(T));
    }

    private String getFinalString(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : S.toCharArray()) {
            final int length = stringBuilder.length();
            if (c - 97 < 0) {
                if (length == 0) {
                    continue;
                }
                stringBuilder.setLength(length - 1);
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
