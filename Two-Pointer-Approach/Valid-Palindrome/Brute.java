// TC -> O(n)
// SC -> O(n)

public class Brute {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }    

    public static boolean isPalindrome(String s) {
        // Logic-
        // remove non-alphanumeric characters and store string in stringbuilder
        // then check original version with reversed version, if both are same return true otherwise false

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}
