// TC -> O(n * logk)
// SC -> O(n)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }    

    public static int[] topKFrequent(int[] nums, int k) {
        // Logic - 
        // create hashmap to store freqs
        // create min heap on pairs, min heap will work on 2nd element i.e. freq of the element
        // will iterate on map and put pairs accordingly and once heap size becomes bigger than k, pop top element which will be the worse element in heap according to freq
        // at the end will have k elements present in heap which will be the top k freq elements
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        // O(n) - Iterating whole array
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        // O(d * logk) - considering worst case, every element in arr is distinct element then instead of d it'll be n
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            minHeap.add(new int[]{key, value});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int index = 0;

        // O(k * logk)
        while (!minHeap.isEmpty()) {
            result[index] = minHeap.poll()[0];
            index++;
        }

        return result;
    }    
}
