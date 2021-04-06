package leetCode;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        /* 8ms
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        */

        // 0ms
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
    
    public int singleNumberII(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            Integer integer = map.get(num);
            map.put(num, integer + 1);
        }

        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }
}
