package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        if (nums.length == 1) {
            return Collections.singletonList(String.valueOf(nums[0]));
        }

        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < nums.length - 1; i++) {
            if (builder.length() == 0) {
                builder.append(nums[i]); // new element
                if (nums[i] + 1 == nums[i + 1]) { // next is consecutive
                    builder.append("->");
                } else { // next is not consecutive, so should go to the list alone
                    ans.add(builder.toString());
                    builder.setLength(0);
                }
                continue;
            }

            if (nums[i] + 1 != nums[i + 1]) {
                builder.append(nums[i]);
                ans.add(builder.toString());
                builder.setLength(0);
            }
        }

        builder.append(nums[nums.length - 1]);
        ans.add(builder.toString());

        return ans;
    }
}
