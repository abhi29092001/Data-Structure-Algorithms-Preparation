// TC -> O(n)
// SC -> O(n)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println(removeDuplicates(s, k));
    }
    
    public static String removeDuplicates(String s, int k) {
        int n = s.length();

        // First Stack to store characters
        Stack<Character> chars = new Stack<>();

        // Second stack to store frequency of those characters
        Stack<Integer> charsOccurences = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // if stack is not empty and top character is same as current character then we'll take top frequency from other stack and increment it by 1
            if (!chars.isEmpty() && chars.peek() == ch) {
                charsOccurences.push(charsOccurences.peek() + 1);
            } else {
                // if the stack is empty or the top char is not same as current char then we'll push 1 in freq stack
                charsOccurences.push(1);
            }

            // irrespective of conditions, char will be pushed anyhow
            chars.push(ch);

            // if peek freq is matched with k that means there exactly k adjacent element in the string, so remove the k characters from stack and remove freq as well
            if (charsOccurences.peek() == k) {
                for (int j = 0; j < k; j++) {
                    chars.pop();
                    charsOccurences.pop();
                }
            }
        }

        // Take chars from stack and put them in sb
        StringBuilder sb = new StringBuilder();
        while (!chars.isEmpty()) {
            sb.append(chars.pop());
        }

        // from stack we got string in a rev order so first reverse it and then convert sb to string and finally return it
        return sb.reverse().toString();
    }
}
