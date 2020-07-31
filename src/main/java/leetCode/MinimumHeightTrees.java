package leetCode;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            addNeighbors(map, edge[0], edge[1]);
            addNeighbors(map, edge[1], edge[0]);
        }

        if (map.isEmpty()) {
            return Collections.singletonList(0);
        }

        List<Integer> leaves = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            if (integerListEntry.getValue().size() == 1) {
                leaves.add(integerListEntry.getKey());
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                Integer leafParentKey = map.get(leaf).get(0);
                map.get(leafParentKey).remove((Integer) leaf);
                if (map.get(leafParentKey).size() == 1) {
                    newLeaves.add(leafParentKey);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }

    private void addNeighbors(Map<Integer, List<Integer>> map, int a, int b) {
        if (map.get(a) == null) {
            List<Integer> list = new ArrayList<>();
            list.add(b);
            map.put(a, list);
        } else {
            List<Integer> integers = map.get(a);
            integers.add(b);
            map.put(a, integers);
        }
    }
}
