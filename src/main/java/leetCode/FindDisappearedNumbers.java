package leetCode;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] array = new int[nums.length + 1];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length + 1) {
                array[nums[i]] = 1;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
