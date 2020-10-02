package leetCode.challenge.october;

import java.util.ArrayList;
import java.util.List;

class RecentCounter {
    List<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) < (t - 3000)) {
                break;
            }
            ans++;
        }
        return ans;
    }
}