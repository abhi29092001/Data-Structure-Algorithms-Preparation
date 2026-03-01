// TC -> O(n)
// SC -> O(n)

import java.util.Stack;

public class Brute {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        int n = s.length;

        // Storing characters in stack and taking out them one by one, so in the end we'll get reversed array
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // pushing characters into stack one by one
            st.push(s[i]);
        }

        int i = 0;
        while (!st.isEmpty()) {
            // pop will return the deleted element from top and gets stored at ith index in the array
            s[i] = st.pop();
            i++;
        }
    }
}
