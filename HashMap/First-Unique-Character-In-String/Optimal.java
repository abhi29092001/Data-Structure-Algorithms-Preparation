// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        String s = "abbccdda";
        System.out.println(firstUniqChar(s));
    }
    
    public static int firstUniqChar(String s) {
        int n = s.length();

        // created 26 size of array for storing freq of lowercase chars
        int[] freq = new int[26];

        // incremented chars freq
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        // again loop over string to check if current char has freq of 1, if it has then that is the answer
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (freq[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
