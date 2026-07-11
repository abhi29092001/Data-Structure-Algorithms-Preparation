// TC -> O(n)
// SC -> O(n)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }    

    public static int largestRectangleArea(int[] heights) {
        // Logic-
        // we'll use stack to push indexes of bars, once we hit a shorter bar we'll pop the top element which is greater bar and after popping take next top element which is the prev smaller bar to the popped bar and find out the area
        // next top element will always be prev smaller coz stack is increasingly monotonic
        // once for loop ends check if there are any bars left in stack
        // if there are then find out area for them as well
        // there are two cases - bars left were smaller bars as bigger bars were popped out
        // other is that bars are only in increasing number i.e. 1 2 3 4 5 like that, there were no increasing decreasing pattern

        int n = heights.length;
        int maxArea = 0;

        // stack used for maintain a increasing monotonic stack, increasing means to get the prev smaller element to the current bar. Pop top element once hit shorter bar
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // run till top is bigger than current bar
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int poppedIndex = st.pop();
                int prevSmaller = -1;

                // if there is no prev smaller take -1
                if (!st.isEmpty()) {
                    prevSmaller = st.peek();
                }

                int width = i - prevSmaller - 1;
                int area = heights[poppedIndex] * width;
                maxArea = Math.max(area, maxArea);
            }

            st.push(i);
        }

        // flush rest of the bars
        while (!st.isEmpty()) {
            int poppedIndex = st.pop();
            int prevSmaller = -1;

            if (!st.isEmpty()) {
                prevSmaller = st.peek();
            }

            // using n instead of i, coz i is not available and in between bigger bars were already flushed out 
            int width = n - prevSmaller - 1;
            int area = heights[poppedIndex] * width;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }    
}
