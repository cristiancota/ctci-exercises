package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Find {
    List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            int index = result.indexOf(item);

            if (index == -1) {
                result.add(item);
                nums[i] = 0;
            } else
                result.remove(index);
        }

        result = new ArrayList<>();

        for (int value : nums)
            if (value > 0 && !result.contains(value)) result.add(value);


        return result;
    }
}
