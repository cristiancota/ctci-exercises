package leetCode;

import java.util.*;

public class GroupPeopleGivenGroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> mapSizeIndex = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            final int currentGroup = groupSizes[i];
            if (mapSizeIndex.get(currentGroup) != null) {
                List<Integer> integers = new ArrayList<>(mapSizeIndex.get(currentGroup));
                integers.add(i);
                mapSizeIndex.put(currentGroup, integers);
            } else {
                mapSizeIndex.put(currentGroup, Collections.singletonList(i));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        mapSizeIndex.forEach((limit, list) -> {
            if (list.size() > limit) {
                List<Integer> auxiliaryList = new ArrayList<>();
                for (Integer integer : list) {
                    auxiliaryList.add(integer);
                    if (auxiliaryList.size() == limit) {
                        ans.add(new ArrayList<>(auxiliaryList));
                        auxiliaryList.clear();
                    }
                }
                if (auxiliaryList.size() > 0) {
                    ans.add(auxiliaryList);
                }
            } else {
                ans.add(list);
            }
        });
        return ans;
    }
}
