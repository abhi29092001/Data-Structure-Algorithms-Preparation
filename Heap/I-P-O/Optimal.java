// TC -> O(k * logn + n * logn)
// SC -> O(n)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        int k = 2;
        int w = 0;
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
    
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Logic -
        // we have to maximise capital means we want maximum profit but with current capital we can only choose projects either less or equal to w. So we sorted according to capital and if capital is same sort it according to profit only
        // now check if capital is <= w then push that profit to heap othwerise break coz its sorted
        // pick top profit from heap add it to w and move on to next set of pairs
        // again repeat same thing until k becomes 0, if you are done with array but still k is not zero that means you can still pick projects so heap will def have profits so you can pick maximum one and add it to w until k becomes 0
        // edge case - if there is no capital less than or equal to w then when you try to take out top element from heap you'll get nothing that means there are no projects which you can take so break out of loop in that case
        // finally return w

        int n = capital.length;

        // O(n) - space
        int[][] arr = new int[n][2];

        // O(n) - space
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // O(n) - time
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{capital[i], profits[i]};
        }

        // O(n logn) - time
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int index = 0;

        // O(k * logn + n * logn) - time
        while (k-- > 0) {
            while (index < n) {
                if (arr[index][0] <= w) {
                    maxHeap.add(arr[index][1]);
                    index++;
                } else {
                    break;
                }
            }

            if (maxHeap.isEmpty()) {
                break;
            } else {
                w += maxHeap.poll();
            }
        }

        return w;
    }
}
