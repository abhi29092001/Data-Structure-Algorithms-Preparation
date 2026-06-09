// TC -> O(n)
// SC -> O(n)-recursive stack space

public class Recursive {
    public static void main(String[] args) {
        String s = "hello";
        reverseString(s);
    }   
    
    public static void reverseString(String s) {
        // code here
        int n = s.length();

        char[] charArray = s.toCharArray();

        helper(charArray, 0, n - 1);

        System.out.println(new String(charArray));
    }
    
    public static void helper(char[] charArray, int i, int j) {
        if (i >= j) {
            return;
        }
        
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        helper(charArray, i + 1, j - 1);
    }    
}
