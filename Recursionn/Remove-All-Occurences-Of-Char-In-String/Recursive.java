// TC -> O(n^2)
// SC -> O(n)-recursive stack space

public class Recursive {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("geeksforgeeks");
        char ch = 'e';
        removeCharacter(s, ch);
    }    
    
    public static void removeCharacter(StringBuilder s, char c) {
        // code here
        helper(s, c, 0);
    }
    
    public static void helper(StringBuilder s, char c, int i) {
        if (i == s.length()) return;
        
        if (s.charAt(i) == c) {
            s.deleteCharAt(i);
            helper(s, c, i);
        } else {
            helper(s, c, i + 1);
        }
    }    
}
