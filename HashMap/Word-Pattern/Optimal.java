// TC -> O(n)
// SC -> O(1)

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }   
    
    public static boolean wordPattern(String pattern, String s) {
        // Logic-
        // firstly, if lengths are not same return false directly
        // need two hashmaps for this problem
        // first is required for char to word mapping
        // second is for word to char mapping

        String[] words = s.split(" ");
        int n = words.length;

        if (pattern.length() != n) {
            return false;
        }

        HashMap<String, Character> wordToChar = new HashMap<>();
        HashMap<Character, String> charToWord = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);

            // if word already exists in map then check whether it is mapped to same current char in pattern, if yes continue coz we dont need to check anything now and if no then move ahead
            if (wordToChar.containsKey(words[i]) && wordToChar.get(words[i]).equals(ch)) {
                continue;
            }
            // if above condition becomes false due to second half that means word is mapped to some other char, return false 
            else if (wordToChar.containsKey(words[i])) {
                return false;
            }
            // we came here means, word doesn't exist in map...check for current char of pattern whether it exists or not. If char is not present in map that means we can map both word and char together 
            else if (!charToWord.containsKey(ch)) {
                charToWord.put(ch, words[i]);
                wordToChar.put(words[i], ch);
            } 
            // we came here means, char exists in map...check if char is mapped to current word in string, if not so it is violating the condition of ques...return false
            else if (!charToWord.get(ch).equals(words[i])) {
                return false;
            }
        }

        return true;
    }
}
