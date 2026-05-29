// TC -> O(n * logk)
// SC -> O(k)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[] arr = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        int k = 4;
        System.out.println(kthSmallest(arr, k));
    }   
    
    public static int kthSmallest(int[] arr, int k) {
        // Logic - 
        // Kth smallest element is asked and min and max heap provides smaller and greatest element in the data.
        // max heap will be used coz we need kth smallest element
        // we'll create heap of size k and afterwards add elements based on whether they are smaller than the peek element, if they are then delete top element and place current element in heap.
        // In the end we'll return top element coz that will be the kth smallest element in the arr and largest element in the max heap.

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // buidling heap of size k - O(k * logk)
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }
        
        // restructuring heap - O((n - k) * logk)
        for (int i = k; i < arr.length; i++) {
            if (maxHeap.peek() > arr[i]) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        
        return maxHeap.peek();
    }    
}
