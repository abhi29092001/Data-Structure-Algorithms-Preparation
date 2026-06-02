// TC -> O(n * logk)
// SC -> O(n)

import java.util.*;

class Pair {
    String first;
    int second;

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Optimal {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        // Logic -
        // Created a hashmap to store the freq of elements
        // Loop through map to put pairs in heap, maintained heap size k
        // Min heap keeps the worst element on top:
        // - lower frequency is worse
        // - if frequencies are same, lexicographically larger word is worse
        // take out element from heap and afterwards reverse coz that is the actual order following higher freq and lexicographical order
        // Return reversed list
        
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();

        // O(n) - building map
        for (int i = 0; i < n; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        // O(k) - space
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a.second != b.second) {
                    return Integer.compare(a.second, b.second);
                } else {
                    return b.first.compareTo(a.first);
                }
            }
        );

        // O(n * logk)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int freq = entry.getValue();

            minHeap.add(new Pair(key, freq));

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // O(k) - space
        List<String> result = new ArrayList<>();

        // O(k * logk)
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().first);
        }

        // O(k) - time
        Collections.reverse(result);
        return result;
    }
}
