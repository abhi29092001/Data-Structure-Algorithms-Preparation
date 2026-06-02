// TC -> O(n logn)
// SC -> O(n)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }    

    public static List<String> topKFrequent(String[] words, int k) {
        // Logic - 
        // Created a hashmap to store the freq of elements
        // Created one list with all keys from map
        // Applied custom sorting based on freq and lexicographical order
        // Return the sub list from 0 to k(excluded)

        int n = words.length;
        Map<String, Integer> map = new HashMap<>();

        // O(n) - building map
        for (int i = 0; i < n; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        // O(n) - auxilary space
        List<String> keys = new ArrayList<>(map.keySet());
        
        // O(n logn) - for sorting
        Collections.sort(keys, (a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return Integer.compare(map.get(b), map.get(a));
            } else {
                return a.compareTo(b);
            }
        });

        return keys.subList(0, k);
    }    
}
