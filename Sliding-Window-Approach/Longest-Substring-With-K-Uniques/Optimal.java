// TC -> O(n)
// SC -> O(k)

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(solution(s, k));
    }

    public static int solution(String s, int k) {
        int size = s.length();
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxLen = -1;
        int low = 0;
        
        for (int high = 0; high < size; high++) {
            freq.put(s.charAt(high), freq.getOrDefault(s.charAt(high), 0) + 1);
            
            while (freq.size() > k) {
                freq.put(s.charAt(low), freq.get(s.charAt(low)) - 1);
                
                if (freq.get(s.charAt(low)) == 0) {
                    freq.remove(s.charAt(low));
                }
                
                low++;
            }
            
            if (freq.size() == k) {
                maxLen = Math.max(maxLen, high - low + 1);
            }
        }
        
        return maxLen;
    }
}
