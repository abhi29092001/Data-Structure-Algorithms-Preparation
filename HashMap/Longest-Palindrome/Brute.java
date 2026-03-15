// TC -> O(n)
// SC -> O(1)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        // Logic is Simple - 
        // 1. if each char is at even frequency then the string given itself is the longest palindrome string possible
        // 2. if string has chars with odd freq then, we can't keep all odd freqs. we can atmost keep only 1 odd freq and rest we have to subtract by 1 to make it even

        int n = s.length();

        // if string length is 1 then, the answer will be 1 only
        if (n == 1) {
            return 1;
        }

        // hashmap to store freq
        HashMap<Character, Integer> freq = new HashMap<>();

        // hashmap to store palindrome string chars - after removing odd freqs
        HashMap<Character, Integer> palindromeChars = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // it will track if we have got odd freq or not, coz we only need 1 odd freq
        boolean oddFound = false;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char k = entry.getKey();
            int v = entry.getValue();

            // if freq is even or first odd then keep it, otherwise decrement by 1 then keep it
            if (v % 2 == 0) {
                palindromeChars.put(k, v);
            } else {
                if (!oddFound) {
                    oddFound = true;
                    palindromeChars.put(k, v);
                } else {
                    palindromeChars.put(k, v - 1);
                }
            }
        }
 
        // palindrome string len count
        int palindromeLen = 0;

        // iterate over palindrome char hashmap to take out the freq and add it in len variable
        for (Integer val : palindromeChars.values()) {
            palindromeLen += val;
        }

        return palindromeLen;
    }
}
