// TC -> O(n + m)
// SC -> O(1)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }
    
    public static boolean canConstruct(String ransomNote, String magazine) {
        // Logic is simple - put ransomNote chars freq in hashmap and then loop on magazine, if magazine char is present in hashmap then reduce the freq of that char...if hashmap size becomes zero that means all the chars of ransomNote is present in magazine and hence using magazine chars we can make ransomNote

        int n = ransomNote.length();
        int m = magazine.length();

        // Hashmap to store ransomNote freq
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = ransomNote.charAt(i);

            // if char is already there then increment by 1 nd if not then take 0 and increment by 1
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            char ch = magazine.charAt(i);

            // if hashmap contains current char then reduce freq by 1 and check if the freq becomes zero then remove that char from hashmap
            if (freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch) - 1);

                if (freq.get(ch) == 0) {
                    freq.remove(ch);
                }
            }

            // if hashmap size became 0 then why to traverse magazine further, exit early
            if (freq.size() == 0) {
                return true;
            }
        }

        return freq.size() == 0;
    }
}
