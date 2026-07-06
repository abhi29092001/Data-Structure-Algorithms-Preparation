// TC -> O(n)
// SC -> O(n)

import java.util.Stack;

public class Optimal {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        // Logic -
        // we'll be requiring last element if the current element is closing bracket to check whether they are matching brackets or not
        // so, stack is the best data structure for this problem

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // if brackets are opening...push it into stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // if bracket is closing one then first check if stack is empty or not
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.peek();

                // if top element is not matching with the closed one then it is clearly false
                if (
                    (top == '(' && ch != ')') || 
                    (top == '[' && ch != ']') ||
                    (top == '{' && ch != '}')
                ) {
                    return false;
                } else {
                    // poping top element, coz it is matching
                    st.pop();
                }
            }
        }

        // if stack is empty that means parenthesis are valid otherwise false
        return st.isEmpty();
    }
}
