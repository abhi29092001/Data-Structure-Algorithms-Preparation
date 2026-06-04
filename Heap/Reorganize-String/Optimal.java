// TC -> O(n)
// SC -> O(1) - Auxilary space

import java.util.*;

class Pair {
    char first;
    int second;

    Pair(char first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Optimal {
    public static void main(String[] args) {
        String s = "aaab";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String s) {
        // Logic -
        // In this ques we need max freq element every time so, max heap gives max element everytime thats why max heap is used in this
        // created map to store freqs
        // created max heap in which freq will be sorted in maximum manner and if freq are equal then bigger elements lexicographically will come on top
        // add key value pairs from map in heap
        // every time we'll take out max element from top and check if its not equal to prev char then place it otherwise keep it and before popping another element will check if heap is empty then return "" otheriwse pop another element and place it and again push it to heap after deducting freq. Make sure push prev popped element as well.
        // finally return string

        int n = s.length();

        // O(26) - space
        Map<Character, Integer> map = new HashMap<>();

        // sorting based on freq and chars
        // O(26) - space
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a.second != b.second) {
                    return Integer.compare(b.second, a.second);
                } 
                return Character.compare(b.first, a.first);
            }
        );

        // O(n) - building map
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // O(26 * log26) - time
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            maxHeap.add(new Pair(ch, freq));
        }

        // O(n) - space
        StringBuilder sb = new StringBuilder();
        int i = 0;

        // O(n * log26) - time
        while (!maxHeap.isEmpty()) {
            // popping top element
            Pair p1 = maxHeap.poll();

            // if string is empty place it otherwise check prev char
            if (sb.length() == 0 || sb.charAt(i - 1) != p1.first) {
                sb.append(p1.first);
                i++;
                p1.second--;

                if (p1.second > 0) {
                    maxHeap.add(p1);
                }
            } else {
                // if top element is same as prev char in string

                if (maxHeap.isEmpty()) {
                    return "";
                } else {
                    Pair p2 = maxHeap.poll();

                    sb.append(p2.first);
                    i++;
                    p2.second--;

                    if (p2.second > 0) {
                        maxHeap.add(p2);
                    }

                    // pushing prev popped pair as well
                    maxHeap.add(p1);
                }
            }
        }

        return sb.toString();
    }
}
