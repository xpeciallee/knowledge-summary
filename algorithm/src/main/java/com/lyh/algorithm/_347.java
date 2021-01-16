package com.lyh.algorithm;

import java.util.*;

public class _347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 1 1 1 2 2 3 3 4
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        List<Integer> result = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<Integer>();
            }
            buckets[frequency].add(entry.getKey());
        }

        for (int i = buckets.length - 1; i > 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    result.add((Integer) buckets[i].get(j));
                }
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = map.get(i);
        }

        return res;
    }
}
