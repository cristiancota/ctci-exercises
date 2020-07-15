package leetCode;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            ans.add(Collections.singletonList(nums[i]));
            Queue<List<Integer>> queue = new LinkedList<>();
            if (i < n - 1) {
                queue.add(Collections.singletonList(nums[i]));
            }
            int index = i + 1;
            while (queue.size() > 0) {
                List<Integer> updatedCurrent = new ArrayList<>(queue.peek());
                updatedCurrent.add(nums[index]);
                ans.add(updatedCurrent);
                if (index < n - 1) {
                    queue.add(updatedCurrent);
                    index++;
                } else {
                    queue.remove();
                    if (queue.size() > 0) {
                        index = map.get(queue.peek().get(queue.peek().size() - 1)) + 1;
                    }
                }
            }
        }
        ans.add(Collections.emptyList());
        return ans;
    }
}
