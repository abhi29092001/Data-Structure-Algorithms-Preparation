// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int best = nums[0];

        for (int i = 1; i < n; i++) {
            int val1 = best + nums[i];
            int val2 = nums[i];

            best = Math.max(val1, val2);
            ans = Math.max(ans, best);
        }

        return ans;
    }
}
