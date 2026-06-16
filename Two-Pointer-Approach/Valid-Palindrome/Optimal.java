// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }    

    public static boolean isPalindrome(String s) {
        // Logic-
        // take two pointers i and j
        // Ignore non-alphanumeric characters and check only actual characters 
        // if both characters are same then increment both pointers and if both are not same that means string is not palindrome return false

        int n = s.length();
        int i = 0;
        int j = n - 1;

        while (i < j) {
            char ch1 = Character.toLowerCase(s.charAt(i));
            char ch2 = Character.toLowerCase(s.charAt(j));

            if (!(ch1 >= 'A' && ch1 <= 'Z') && !(ch1 >= 'a' && ch1 <= 'z') && !(ch1 >= '0' && ch1 <= '9')) {
                i++;
            } else if (!(ch2 >= 'A' && ch2 <= 'Z') && !(ch2 >= 'a' && ch2 <= 'z') && !(ch2 >= '0' && ch2 <= '9')) {
                j--;
            } else if (ch1 == ch2) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }    
}
