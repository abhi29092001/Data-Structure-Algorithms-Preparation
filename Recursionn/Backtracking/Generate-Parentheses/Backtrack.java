// TC -> will update later
// SC -> O(2n)->O(n)

import java.util.*;

public class Backtrack {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, n, 0, 0, "");
        return result;
    }

    public static void helper(List<String> result, int n, int open, int close, String str) {
        if (open == n && close == n) {
            result.add(str);
            return;
        }

        if (open < n) {
            helper(result, n, open + 1, close, str + '(');
        }

        // avoiding invalid choice
        if (close < open) {
            helper(result, n, open, close + 1, str + ')');
        }
    }    
}
