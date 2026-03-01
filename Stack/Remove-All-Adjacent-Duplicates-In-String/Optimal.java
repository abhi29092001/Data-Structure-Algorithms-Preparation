// TC -> O(n)
// SC -> O(n)

public class Optimal {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }   
    
    public static String removeDuplicates(String s) {
        // Not using stack but the concept is of stack...stack can also be used
        // Using sb coz normal string is immutable
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char chAtIndexI = s.charAt(i);
            int lastIndexOfSb = sb.length() - 1;

            // if length of sb is greater than 0 and if the last character in sb is same as character at ith index that means both are same adjacent characters...so delete it from sb...otherwise append it in sb
            if (sb.length() > 0 && sb.charAt(lastIndexOfSb) == chAtIndexI) {
                sb.deleteCharAt(lastIndexOfSb);
            } else {
                sb.append(chAtIndexI);
            }
        }

        return sb.toString();
    }
}
