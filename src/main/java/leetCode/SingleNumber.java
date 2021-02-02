package leetCode;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        /* 8ms
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        */

        // 0ms
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
