package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeopleGivenGroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> mapSizeIndex = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            final int groupLimit = groupSizes[i];
            if (mapSizeIndex.get(groupLimit) != null) {
                List<List<Integer>> lists = mapSizeIndex.get(groupLimit);
                boolean addNewList = true;
                for (List<Integer> list : lists) {
                    if (list.size() < groupLimit) {
                        list.add(i);
                        addNewList = false;
                        break;
                    }
                }
                if (addNewList) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(i);
                    lists.add(integers);
                }
            } else {
                List<List<Integer>> list = new ArrayList<>();
                list.add(new ArrayList<>());
                list.get(0).add(i);
                mapSizeIndex.put(groupLimit, list);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        mapSizeIndex.values().forEach(ans::addAll);
        return ans;
    }
}
