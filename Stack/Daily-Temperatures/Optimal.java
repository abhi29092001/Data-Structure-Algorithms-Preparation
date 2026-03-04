// TC -> O(n)
// SC -> O(n)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperatures(temperatures));
    }
    
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] resArray = new int[n];
        Stack<Integer> st = new Stack<>();
        
        // Storing last element's answer in array i.e. 0 (we can also avoid that as default value of array is zero)
        resArray[n - 1] = 0;

        // Storing last index in stack
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            // popping till we get the index which has greater element then temp array
            while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }

            // calculate index diff
            if (!st.isEmpty()) {
                resArray[i] = st.peek() - i;
            }

            st.push(i);
        }

        return resArray;
    }    
}
