package leetCode;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) { // binary search
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            int mid = nums[midIndex];

            if (mid == target) {
                return midIndex;
            }

            int left = nums[leftIndex];

            if (left <= mid) { // left part is sorted
                if (target > left && target < mid) { // target is in [left...mid]
                    rightIndex = midIndex - 1;
                } else if (target == left) {
                    return leftIndex;
                } else { // target is in [mid...right]
                    leftIndex = midIndex + 1;
                }
            } else { // right part is sorted
                int right = nums[rightIndex];

                if (target > mid && target < right) { // target is in [mid...right]
                    leftIndex = midIndex + 1;
                } else if (target == right) {
                    return rightIndex;
                } else {
                    rightIndex = midIndex - 1;
                }
            }
        }

        return -1;
    }
}
