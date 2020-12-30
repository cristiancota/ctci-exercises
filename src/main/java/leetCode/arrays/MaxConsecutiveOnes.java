package leetCode.arrays;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = nums[0] == 1 ? 1 : 0;
        int current = max;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
            } else {
                max = Math.max(current, max);
                current = 0;
            }
        }

        max = Math.max(current, max);
        return max;
    }
}
