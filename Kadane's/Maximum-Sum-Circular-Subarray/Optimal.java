// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {5,-3,5};
        System.out.println(maxSubarraySumCircular(nums));
    }
    
    public static int maxSubarraySumCircular(int[] nums) {
        // Logic-
        // This is a circular array
        // in this we need to track both maxsum and minsum, means maxending sum and minending sum
        // and in this we need to remove minimum sum from the array to get max sum subarray
        // if all elements are -ve then return maxSum directly, coz sum-minsum will be 0
        // but if all elements are not -ve then check which one is maximum, maxsum or sum-minsum 

        int n = nums.length;
        int maxSum = nums[0];
        int minSum = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int sum = nums[0];

        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            minEnding = Math.min(minEnding + nums[i], nums[i]);
            sum += nums[i];

            maxSum = Math.max(maxSum, maxEnding);
            minSum = Math.min(minSum, minEnding);
        }

        // edge case - if all elements are -ve then sum-minSum will be zero and maxSum will definitely be a -ve number that means (sum - minSum > maxSum), in that case we'll return maxSum directly
        if (sum - minSum == 0) {
            return maxSum;
        }

        return Math.max(maxSum, sum - minSum);
    }    
}
