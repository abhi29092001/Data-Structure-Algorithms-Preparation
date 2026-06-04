// TC -> O(n^2 logn)
// SC -> O(n)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        // Logic -
        // first created an arraylist so that we can mutate it
        // before starting anything sort the list
        // each time take two last element coz they are maximum
        // check if they are not equal if so then subtract them and push result into list for next set of operations
        // before starting next iteration sort list again, to get two max elements
        // run loop if list size is greater than 1
        // when loop terminates then check if size is 0 then return 0 otherwise first element of list

        int n = stones.length;

        // O(n) - size
        List<Integer> list = new ArrayList<>();

        // O(n) - time
        for (int i = 0; i < n; i++) {
            list.add(stones[i]);
        }

        // O(n * (n logn)) -> O(n^2 logn) - time
        while (list.size() > 1) {
            Collections.sort(list, (a, b) -> Integer.compare(a, b));
            
            int max1 = list.remove(list.size() - 1);
            int max2 = list.remove(list.size() - 1);

            if (max1 != max2) {
                int result = Math.abs(max1 - max2);
                list.add(result);
            }
        }

        return list.size() == 0 ? 0 : list.get(0);
    }
}
