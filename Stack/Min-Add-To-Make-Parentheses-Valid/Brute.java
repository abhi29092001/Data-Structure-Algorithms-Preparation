// TC -> O(n)
// SC -> O(n)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        int n = s.length();

        // Stack for storing parentheses
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // if top is opening parentheses and current is closing one then pop it, else push into the stack
            if (!st.isEmpty() && (st.peek() == '(' && s.charAt(i) == ')')) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        // counter for counting the remaining parentheses and that will be the answer
        
        // METHOD 1:
        // int count = 0;

        // if (st.isEmpty()) {
        //     return count;
        // } else {
        //     while (!st.isEmpty()) {
        //         st.pop();
        //         count++;
        //     }
        // }

        // METHOD 2:
        // directly return stack size and that is what we are doing above... getting remaining stack elements
        return st.size();
    }
}
