package leetCode;

import java.util.Arrays;

public class SmallesStringWithNumericValue {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        k -= n;
        int index = ans.length - 1;

        while (k >= 26) {
            ans[index] = 'z';
            k = k + 1 - 26;
            index--;
        }

        ans[index] = (char) (k + 'a');
        return new String(ans);
    }
}
