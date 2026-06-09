// TC -> O(n)
// SC -> O(n)-recursion stack space

public class Recursive {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(isPalindrome(s));
    }   
    
    public static boolean isPalindrome(String s) {
        // code here
        int n = s.length();
        return helper(s, 0, n - 1);
    }
    
    public static boolean helper(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        
        if (s.charAt(i) == s.charAt(j) && helper(s, i + 1, j - 1)) {
            return true;
        }
        return false;
    }   
}
