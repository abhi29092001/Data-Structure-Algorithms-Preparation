// TC -> O(4^n * n) - extra n coz of toString() it takes O(n)
// SC -> O(n)-recursive stack space

import java.util.*;

public class Backtrack {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    } 
    
    public static List<String> letterCombinations(String digits) {
        Map<Character, String> keypad = new HashMap<>();
        initializeKeypad(keypad);
        StringBuilder diary = new StringBuilder("");
        List<String> result = new ArrayList<>();
        helper(digits, digits.length(), 0, keypad, diary, result);
        return result;
    }

    public static void initializeKeypad(Map<Character, String> keypad) {
        keypad.put('2', "abc");
        keypad.put('3', "def");
        keypad.put('4', "ghi");
        keypad.put('5', "jkl");
        keypad.put('6', "mno");
        keypad.put('7', "pqrs");
        keypad.put('8', "tuv");
        keypad.put('9', "wxyz");
    }

    public static void helper(String digits, int n, int i, Map<Character, String> keypad, StringBuilder diary, List<String> result) {
        if (i == n) {
            result.add(diary.toString());
            return;
        }

        String word = keypad.get(digits.charAt(i));
        
        for (int j = 0; j < word.length(); j++) {
            diary.append(word.charAt(j));
            helper(digits, n, i + 1, keypad, diary, result);
            diary.deleteCharAt(diary.length() - 1);
        }
    } 
}
