// TC -> O(n)
// SC -> O(1)

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int n = s.length();
        int maxLen = 0;
        int low = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++) {
            freq.put(s.charAt(high), freq.getOrDefault(s.charAt(high), 0) + 1);
            int windowLen = high - low + 1;

            while (freq.size() < windowLen) {
                freq.put(s.charAt(low), freq.get(s.charAt(low)) - 1);
                if (freq.get(s.charAt(low)) == 0) {
                    freq.remove(s.charAt(low));
                }
                low++;
                windowLen = high - low + 1;
            }

            maxLen = Math.max(maxLen, windowLen);
        }

        return maxLen;
    }
}
