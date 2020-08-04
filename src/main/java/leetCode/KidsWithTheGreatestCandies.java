package leetCode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        List<Boolean> ans = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) {
            ans.add(i, candies[i] + extraCandies >= max);
        }
        return ans;
    }
}
