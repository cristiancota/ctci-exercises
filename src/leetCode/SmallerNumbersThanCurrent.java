package leetCode;

public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int total = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j || nums[i] < nums[j]) continue;
                total++;
            }
            result[i] = total;
        }

        return result;
    }
}
