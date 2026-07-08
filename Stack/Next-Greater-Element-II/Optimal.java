// TC -> O(n)
// SC -> O(n)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(nextGreaterElements(nums));
    }
    
    public static int[] nextGreaterElements(int[] nums) {
        // Logic-
        // the array is circular one
        // so need to push the array first
        // then will find out the greater element from right side as array is circular so it will wrap around
        // it will be easy if we handle wrap case first and then normal case 
        // if there is no greater, keep popping
        // if stack becomes empty after popping that means there is no element greater 
        // if top is greater, keep it in result array and push current element into stack
        // we're not removing top element as maybe it will be answer for some other element 

        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        // To store the next greater element
        int[] resArray = new int[n];

        // first we need to push elements because array is circular 
        for (int i = n - 2; i >= 0; i--) {
            st.push(nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }

            if (!st.isEmpty()) {
                resArray[i] = st.peek();
            } else {
                resArray[i] = -1;
            }

            st.push(nums[i]);
        }

        return resArray;
    }
}
