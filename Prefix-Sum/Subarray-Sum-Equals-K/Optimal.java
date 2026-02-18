// TC -> O(n)
// SC -> O(n)

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();

        // k = sum - (sum - k)
        // if (sum-k) gives 0 then, that means k = sum, that's why it must be present in the hashmap so that we can increment 1 when we encounter such scenario
        freq.put(0, 1);

        for (int i = 0; i < n; i++) {
            // Add current element to the sum variable
            sum += nums[i];

            int sumMinusK = sum - k;

            // If sumMinusK is present in hashmap then give the value of that otherwise give 0, freq of sumMinusK tells how many subarrays are there from 0 to i(where sum variable is current at) whose sum is equal to k
            int sumMinusKFreq = freq.getOrDefault(sumMinusK, 0);

            // Add sumMinusKFreq in count variable
            count += sumMinusKFreq;

            // put current sum value in hashmap, so that it can become sumMinusK at some point and you can find subarrays from 0 to i(where sum variable is current at); That's why its a prefix Sum ques, you are asking or checking previous Sums and making decisions based on that
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
