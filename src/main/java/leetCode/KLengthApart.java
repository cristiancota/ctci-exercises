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

    public static void main(String[] args) {
        KLengthApart kLengthApart = new KLengthApart();
        kLengthApart.kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2);
        kLengthApart.kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2);
        kLengthApart.kLengthApart(new int[]{1, 1, 1, 1, 1}, 0);
        kLengthApart.kLengthApart(new int[]{0, 1, 0, 1}, 1);
    }

}
