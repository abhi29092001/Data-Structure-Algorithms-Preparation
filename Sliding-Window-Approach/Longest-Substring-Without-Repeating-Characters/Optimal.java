// TC -> O(n)
// SC -> O(min(m,n))

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        // Logic-
        // we'll using sliding window coz we need to find len of longest substring and we'll use hashmap to track the freq of chars
        // high will keep on moving until len becomes greater than freq's size if that happens that means there is some duplicate in the string
        // remove duplicate by shrinking window from left side, also remove/reduce freq of char from left side,calculate updated len
        // finally return maxlen 

        int n = s.length();
        int maxLen = 0;
        int low = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            int len = high - low + 1;

            while (freq.size() < len) {
                freq.put(s.charAt(low), freq.getOrDefault(s.charAt(low), 0) - 1);

                if (freq.get(s.charAt(low)) == 0) {
                    freq.remove(s.charAt(low));
                }

                low++;
                len = high - low + 1;
            } 

            if (len > maxLen) {
                maxLen = len;
            }
        }

        return maxLen;
    }
}
