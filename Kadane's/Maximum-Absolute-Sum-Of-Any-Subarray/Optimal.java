// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {1,-3,2,3,-4};
        System.out.println(maxAbsoluteSum(nums));
    }
    
    public static int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int minSum = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            minSum = Math.min(minSum + nums[i], nums[i]);

            ans = Math.max(ans, Math.max(maxSum, Math.abs(minSum)));
        }

        // If array has only 1 element and that too negative, so returning abs value
        return Math.abs(ans);
    }
}
