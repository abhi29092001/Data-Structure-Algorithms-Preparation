// TC -> O(n^2)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }    

    public static int maxSubArray(int[] nums) {
        // Logic-
        // finding sum of each subarray and checking if its maximum then maxsum, assign it to maxsum
        // finally, after iterating and finding out sum of every subarray, return maxsum

        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}
