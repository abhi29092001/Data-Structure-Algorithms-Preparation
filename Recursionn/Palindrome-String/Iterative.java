// TC -> O(n)
// SC -> O(1)

public class Iterative {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(isPalindrome(s));
    }   
    
    public static boolean isPalindrome(String s) {
        // code here
        int i = 0;
        int j = s.length() - 1;
        
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
