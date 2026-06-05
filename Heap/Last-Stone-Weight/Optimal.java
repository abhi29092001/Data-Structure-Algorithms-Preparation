// TC -> O(n logn)
// SC -> O(n)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        // Logic -
        // first created a max heap coz we want max element and max heap gives max element
        // each time take two max element from top
        // check if they are not equal if so then subtract them and push result into heap again for next set of operations
        // run loop if heap size is greater than 1
        // when loop terminates then check if size is 0 then return 0 otherwise top element of heap

        int n = stones.length;

        // O(n) - space
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // O(n * logn) - time
        for (int i = 0; i < n; i++) {
            maxHeap.add(stones[i]);
        }

        // O(n * logn) - time
        while (maxHeap.size() > 1) {
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();

            if (max1 != max2) {
                int result = max1 - max2;
                maxHeap.add(result);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }    
}
