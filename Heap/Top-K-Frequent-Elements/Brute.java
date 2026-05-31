// TC -> O(n * k)
// SC -> O(n)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }    

    public static int[] topKFrequent(int[] nums, int k) {
        // Logic - 
        // Created a hashmap to store the freq of elements
        // Created two arrays one for storing keys and one for values
        // keep on adding keys and values until the size reaches k, so that we can start comparing and find min value
        // start searching for min value in values array so that we can replace it with higher value from map if there is any along with the key
        // once we reaches at end of map return keys array

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        // building map - O(n)
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // O(k + k) - O(k)
        int[] keys = new int[k];
        int[] values = new int[k];
        int size = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (size < k) {
                keys[size] = key;
                values[size] = value;
                size++;
            } else {
                int minIndex = 0;
                for (int i = 1; i < k; i++) {
                    if (values[i] < values[minIndex]) {
                        minIndex = i;
                    }
                }

                if (value > values[minIndex]) {
                    keys[minIndex] = key;
                    values[minIndex] = value;
                }
            }
        }

        return keys;
    }
}
