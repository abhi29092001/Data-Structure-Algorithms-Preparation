// TC -> O(n)
// SC -> O(n)

public class Optimal2 {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // if brackets are opening...push it into sb
            if (ch == '(' || ch == '{' || ch == '[') {
                sb.append(ch);
            } else {
                // if bracket is closing one then first check if sb is empty or not
                if (sb.length() == 0) {
                    return false;
                }

                char last = sb.charAt(sb.length() - 1);

                // if last element is not matching with the closed one then it is clearly false
                if (
                    (last == '(' && ch != ')') || 
                    (last == '[' && ch != ']') ||
                    (last == '{' && ch != '}')
                ) {
                    return false;
                } else {
                    // poping last element, coz it is matching
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        // if sb is empty that means parenthesis are valid otherwise false
        return sb.length() == 0;
    }    
}
