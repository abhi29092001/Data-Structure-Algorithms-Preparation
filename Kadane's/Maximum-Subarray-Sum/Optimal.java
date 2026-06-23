// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // Logic-
        // used kadane's algo, coz we need to find maxsum of subarray(-ves are also there in array)
        // at current index we'll check if after taking it and adding it to best will give me better result or dropping my prev best and taking only current element will result in best
        // after taking maximum best, compare with ans, if ans is smaller then assign best to ans
        // after completing loop, return ans 

        int n = nums.length;
        int ans = nums[0];
        int best = nums[0];

        for (int i = 1; i < n; i++) {
            best = Math.max(nums[i], best + nums[i]);
            ans = Math.max(ans, best);
        }

        return ans;
    }
}
