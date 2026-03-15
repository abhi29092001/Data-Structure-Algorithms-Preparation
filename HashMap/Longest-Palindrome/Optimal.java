// TC -> O(n)
// SC -> O(1)

public class Optimal {
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

        // array to store freq
        int[] freq = new int[58];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'A']++;
        }

        // it will track if we have got odd freq or not, coz we only need 1 odd freq
        boolean oddFound = false;

        // palindrome string len count
        int palindromeLen = 0;

        for (int i = 0; i < 58; i++) {
            // if freq is even or first odd then keep it, otherwise decrement by 1 then keep it
            if (freq[i] % 2 == 0) {
                palindromeLen += freq[i];
            } else {
                if (!oddFound) {
                    oddFound = true;
                    palindromeLen += freq[i];
                } else {
                    palindromeLen += freq[i] - 1;
                }
            }
        }

        return palindromeLen;
    }
}
