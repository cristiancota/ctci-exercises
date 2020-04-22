package leetCode;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int required;
        for (int i = 0; i < nums.length; i++) {
            required = target - nums[i];
            int pair = -1;

            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }

                if (nums[j] == required) {
                    pair = j;
                    break;
                }
            }

            if (pair != -1) {
                return new int[]{i, pair};
            }

        }

        return new int[]{-1, -1};
    }
}
