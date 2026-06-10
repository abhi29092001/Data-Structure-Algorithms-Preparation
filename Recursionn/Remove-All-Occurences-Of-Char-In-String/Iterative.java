// TC -> O(n^2)
// SC -> O(1)

public class Iterative {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("geeksforgeeks");
        char ch = 'e';
        removeCharacter(s, ch);
    }    
    
    public static void removeCharacter(StringBuilder s, char c) {
        // code here
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) == c) {
                s.deleteCharAt(i); // takes O(n) coz shifting happens in deletion
            }
        }
    }
}
