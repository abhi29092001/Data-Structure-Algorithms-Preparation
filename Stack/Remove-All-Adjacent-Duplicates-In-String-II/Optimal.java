// TC -> O(n)
// SC -> O(n)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println(removeDuplicates(s, k));
    }
    
    public static String removeDuplicates(String s, int k) {
        int n = s.length();

        // stack to store an array containing character and frequency
        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // STORING EACH ADJACENT ELEMENT EVERYTIME WITH ITS UPDATED FREQUENCY
            // if (!st.isEmpty() && st.peek()[0] == ch) {
            //     st.push(new int[]{ch, st.peek()[1] + 1});
            // } else {
            //     st.push(new int[]{ch, 1});
            // }

            // if (st.peek()[1] == k) {
            //     for (int j = 0; j < k; j++) {
            //         st.pop();
            //     }
            // }

            // STORING SAME ADJACENT ELEMENT ONLY ONCE AND UPDATING FREQUENCY IN SAME PLACE (MORE OPTIMIZED) 
            if (!st.isEmpty() && st.peek()[0] == ch) {
                st.peek()[1]++;

                if (st.peek()[1] == k) {
                    st.pop();
                }
            } else {
                st.push(new int[]{ch, 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            // Only this is required with first approach
            // sb.append((char)st.pop()[0]);

            // This for loop is also required because there is single pair containing character and its total adjacent freq
            for (int i = 0; i < st.peek()[1]; i++) {
                sb.append((char)st.peek()[0]);
            }
            st.pop();
        }

        return sb.reverse().toString();
    }
}
