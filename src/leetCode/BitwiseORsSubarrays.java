package leetCode;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsSubarrays {
//    brute force solution.
//
//    public int subarrayBitwiseORs(int[] A) {
//        Set<Integer> ans = new HashSet<>();
//        for (int i = 0; i < A.length; i++) {
//            int current = 0;
//            for (int j = i; j < A.length; j++) {
//                current |= A[j];
//                ans.add(current);
//            }
//        }
//        return ans.size();
//    }

    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet<>(), cur = new HashSet<>(), cur2;
        for (Integer i : A) {
            cur2 = new HashSet<>();
            cur2.add(i);
            for (Integer j : cur) {
                cur2.add(i | j);
            }
            ans.addAll(cur = cur2);
        }
        return ans.size();
    }
}