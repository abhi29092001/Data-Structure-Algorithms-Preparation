// TC -> O(n + m)
// SC -> O(m)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(nextGreaterElement(nums1, nums2));
    }
    
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Logic-
        // stack will be used in this ques as ques is asking for next greater element
        // will use stack and check whether the top element is lesser than the current element, if so that means top element's greater element is current element and store it in hashmap for further use
        // once done now loop on 1st array to find out greater elements for elements lying in array1, use hashmap for lookup

        // to check whether top is lesser than current element or not
        Stack<Integer> st = new Stack<>();

        // To store the element -> nextGreaterElement
        Map<Integer, Integer> map = new HashMap<>(); 

        int[] resArray = new int[nums1.length];

        // Buidling monotonic stack and storing key-value pair in map 
        for (int j = 0; j < nums2.length; j++) {
            while (!st.isEmpty() && st.peek() < nums2[j]) {
                map.put(st.pop(), nums2[j]);
            }
            st.push(nums2[j]);
        }

        for (int i = 0; i < nums1.length; i++) {
            resArray[i] = map.getOrDefault(nums1[i], -1);
        }

        return resArray;
    }    
}
