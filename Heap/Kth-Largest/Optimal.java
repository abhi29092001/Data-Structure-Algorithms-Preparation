// TC -> O(n * logk)
// SC -> O(k)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(arr, k));
    }
    
    public static int findKthLargest(int[] nums, int k) {
        // Logic - 
        // Kth largest element is asked and min and max heap provides smaller and greatest element in the data.
        // min heap will be used coz we need kth largest element
        // we'll create heap of size k and afterwards add elements based on whether they are greater than the peek element, if they are then delete top element and place current element in heap.
        // In the end we'll return top element coz that will be the kth largest element in the arr and smallest element in the min heap.

        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap

        // building heap of size k - O(k * logk)
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        // restructuring heap as we need kth largest element - O(n - k) * O(logk + logk)
        for (int i = k; i < n; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }
}
