// TC -> O(n)
// SC -> O(n)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        String num = "10";
        int k = 2;
        System.out.println(removeKdigits(num, k));
    }
    
    public static String removeKdigits(String num, int k) {
        int n = num.length();

        // Edge case :- if k is same as string length
        if (k == n) {
            return "0";
        }

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            // remove the top element until we get smaller element on top 
            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            } 
            st.push(ch);
        }

        // edge case :- if the digits are same in the string
        while (k > 0) {
            st.pop();
            k--;
        }

        // Taking out the elements from top of the stack and appending it to sb
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        // Before reversing check if the last element is zero then delete it from sb
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // if there is one element in the sb and that too 0 then above loop will remove that so, need to return 0 explicitly
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
