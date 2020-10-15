package leetCode.challenge.october;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(nums[i] + memo[i - 2], memo[i - 1]);
        }

        return memo[nums.length - 1];
    }

    public int rob2(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 0) {
            return 0;
        }

        int nums0 = nums[0];
        if (numsLength == 1) {
            return nums0;
        }

        int nums1 = nums[1];
        int max01 = Math.max(nums0, nums1);
        if (numsLength == 2) {
            return max01;
        }

        int nums2 = nums[2];
        if (numsLength == 3) {
            return Math.max(max01, nums2);
        }

        int memoSize = numsLength - 1;
        int[] memoButLast = new int[memoSize];

        memoButLast[0] = nums0;
        memoButLast[1] = max01;

        for (int i = 2; i < memoSize; i++) {
            memoButLast[i] = Math.max(nums[i] + memoButLast[i - 2], memoButLast[i - 1]);
        }

        int[] memoButFirst = new int[memoSize];

        memoButFirst[0] = nums1;
        memoButFirst[1] = Math.max(nums1, nums2);

        for (int i = 2; i < memoSize; i++) {
            memoButFirst[i] = Math.max(nums[i + 1] + memoButFirst[i - 2], memoButFirst[i - 1]);
        }

        return Math.max(memoButLast[numsLength - 2], memoButFirst[numsLength - 2]);
    }
}
