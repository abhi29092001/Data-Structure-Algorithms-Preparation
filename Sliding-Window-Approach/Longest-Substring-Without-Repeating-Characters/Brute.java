// TC -> O(n^2)
// SC -> O(min(m,n)) - m(charset),n(string length)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(findLength(s));
    }    

    public static int findLength(String s) {
        // Logic-
        // we're going at every char and checking wthether this char is present in hashmap or not, if it is present then break out of inner loop, if not then calculate len,maxLen and move forward, make sure you put that char in hashmap also
        // finally return maxLen 

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int len = 0;
            Map<Character, Integer> freq = new HashMap<>();

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                if (freq.containsKey(ch)) {
                    break;
                } else {
                    freq.put(ch, 1);
                    len = j - i + 1;

                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }

        return maxLen;
    }
}
