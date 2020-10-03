package leetCode.challenge.october;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//K-diff Pairs in an Array
public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                final int a = nums[i];
                final int b = nums[j];
                final int diff = Math.abs(a - b);
                if (i != j && a <= b && (diff == k)) {
                    set.add(Arrays.asList(a,b));
                }
            }
        }

        return set.size();
    }
}
