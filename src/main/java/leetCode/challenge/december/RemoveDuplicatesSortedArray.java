package leetCode.challenge.december;

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;

        if (length < 3) {
            return length;
        }

        int a = 2;
        int b = a;

        while (b < length) {
            if (nums[a - 2] != nums[b]) {
                nums[a++] = nums[b];
            }
            b++;
        }

        return a;
    }
}
