package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        helper(ans, digits, "", 0, map);

        return ans;
    }

    private void helper(List<String> ans, String digits, String current, int index, Map<String, String> map) {
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        String string = map.get(String.valueOf(digits.charAt(index)));
        for (int i = 0; i < string.length(); i++) {
            helper(ans, digits, current + string.charAt(i), index + 1, map);
        }
    }
}
