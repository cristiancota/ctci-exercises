package leetCode;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    private int searchHelper(int[] nums, int target, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return -1;
        }

        int currentIndex = (endIndex + startIndex) / 2;

        if (nums[currentIndex] == target) {
            return currentIndex;
        } else if (nums[currentIndex] < target) { // target is higher
            return searchHelper(nums, target, currentIndex + 1, endIndex); // go right
        } else { // target is lower
            return searchHelper(nums, target, startIndex, currentIndex - 1); // go left
        }
    }
}
