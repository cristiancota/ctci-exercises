package leetCode.challenge.october;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashMap<Integer, Set<List<Integer>>> memo = new HashMap<>();
        Set<List<Integer>> lists = combinationSumHelper(candidates, target, memo, new ArrayList<>(), 0);
        return lists == null ? Collections.emptyList() : new ArrayList<>(lists);
    }

    private Set<List<Integer>> combinationSumHelper(int[] candidates, int target, HashMap<Integer, Set<List<Integer>>> setResult, List<Integer> currentList, int currentCandidate) {
        if (target < 0) {
            return null;
        }

        if (target == 0) {
            ArrayList<Integer> listClone = new ArrayList<>(currentList);
            listClone.add(currentCandidate);
            Collections.sort(listClone);

            if (setResult.get(target) == null) {
                Set<List<Integer>> set = new HashSet<>();
                set.add(listClone);
                setResult.put(target, set);
            } else {
                Set<List<Integer>> set = setResult.get(target);
                set.add(listClone);
            }

            return null;
        }

        for (int candidate : candidates) {
            ArrayList<Integer> listClone = new ArrayList<>(currentList);
            if (currentCandidate > 0) {
                listClone.add(currentCandidate);
            }
            combinationSumHelper(candidates, target - candidate, setResult, listClone, candidate);
        }

        return setResult.get(0);
    }
}


