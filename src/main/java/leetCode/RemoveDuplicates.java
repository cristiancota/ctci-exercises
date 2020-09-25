package leetCode;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int nextIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            if (currentNum > nums[nextIndex - 1]) {
                nums[nextIndex] = currentNum;
                nextIndex++;
            }
        }
        return nextIndex;
    }
}
