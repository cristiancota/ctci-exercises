package leetCode;

public class KLengthApart {
    public boolean kLengthApart(int[] nums, int k) {
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                start = i + 1;
                break;
            }
        }

        if (start == 0) {
            return true;
        }

        int count = 0;

        for (int i = start; i < nums.length; i++) {
            count++;
            if (nums[i] == 1) {
                if (count > k) {
                    count = 0;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
