package leetCode;

import java.util.Arrays;

public class TargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        final int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < length; i++) {
            final int currentIndex = index[i];
            if (ans[currentIndex] != -1) {
                displaceElements(ans, currentIndex);
            }
            ans[currentIndex] = nums[i];
        }
        return ans;
    }

    private void displaceElements(int[] ans, int index) {
        final int length = ans.length - 1 - index;
        if (length >= 0) {
            System.arraycopy(ans, index, ans, index + 1, length);
        }
    }
}
