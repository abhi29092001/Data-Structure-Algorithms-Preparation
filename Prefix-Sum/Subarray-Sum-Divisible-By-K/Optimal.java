// TC -> O(n)
// SC -> O(min(n, k))

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 4};
        int k = 2;
        System.out.println(subarraysDivByK(nums, k));
    }

    // This ques is kinda same as subarray sum equals k, the difference is...this time we are checking and putting remainder in hashmap instead of sum-k
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        // If we encounter remainder 0, then it will not be counted if we initially don't set it to 1 in hashmap.
        freq.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            // Finding remainder of the sum, which finally searched in the hashmap
            int remainder = sum % k;

            // edge case for negative remainders, because valid remainders are 0 to k-1 but -ve remainders break this logic so that's why +k is needed in the remainder. -1 belongs to 4, -2 belongs and so on.
            if (remainder < 0) {
                remainder += k;
            }

            int remainderFreq = freq.getOrDefault(remainder, 0);

            count += remainderFreq;

            freq.put(remainder, freq.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
