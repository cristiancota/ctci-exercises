package leetCode.design;

import java.util.*;

public class LRUCache {
    Map<Integer, Integer> map;
    List<Integer> historyVisited;
    private int _capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        _capacity = capacity;
        historyVisited = new ArrayList<>(capacity);
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        historyVisited.remove((Integer) key);
        historyVisited.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            map.remove(key);
            historyVisited.remove((Integer) key);
        }
        if (map.size() == _capacity) {
            map.remove(historyVisited.get(0));
            historyVisited.remove(0);
        }
        historyVisited.add(key);
        map.put(key, value);
    }
}
