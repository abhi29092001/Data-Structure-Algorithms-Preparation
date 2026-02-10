// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int val1 = maxEnding * nums[i];
            int val2 = minEnding * nums[i];
            int val3 = nums[i];

            maxEnding = Math.max(Math.max(val1, val2), val3);
            minEnding = Math.min(Math.min(val1, val2), val3);
            ans = Math.max(ans, Math.max(maxEnding, minEnding));
        }
        
        return ans;
    }
}
