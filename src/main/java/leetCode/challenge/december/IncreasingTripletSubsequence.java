package leetCode.challenge.december;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) {
                    break;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[j] && nums[j] > nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
