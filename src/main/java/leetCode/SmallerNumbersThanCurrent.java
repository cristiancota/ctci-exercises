package leetCode;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int[] original = nums.clone();
        Arrays.sort(nums);

        for (int i = 0; i < result.length; i++) {
            int total = 0;
            int currentOriginal = original[i];
            while (nums[total] < currentOriginal) {
                total++;
            }
            result[i] = total;
        }

        return result;
    }
}
