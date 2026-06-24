// TC -> O(n)
// SC -> O(1)

public class ExtendedOptimal {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // Logic-
        // This is an extended version, all logic remains same just few lines need to be added to track the max sum subarray
        // used kadane's algo, coz we need to find maxsum of subarray(-ves are also there in array)
        // at current index we'll check if after taking it and adding it to best will give me better result or dropping my prev best and taking only current element will result in best
        // after taking maximum best, compare with ans, if ans is smaller then assign best to ans
        // after completing loop, return ans 

        int n = nums.length;
        int ans = nums[0];
        int best = nums[0];
        int start = 0;
        int end = 0;

        for (int i = 1; i < n; i++) {
            int value1 = nums[i];
            int value2 = best + nums[i];
            
            // tracking indices based on ans
            // new bigger sum subarray found, reset window
            if (value1 > ans) {
                start = i;
                end = i;
            } // keep going on with prev subarray by extending window
             else if (value2 > ans) {
                end = i;
            }
            //******
            
            best = Math.max(value1, value2);
            ans = Math.max(ans, best);
        }
        
        // printing subarray
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        
        System.out.println();

        return ans;
    }
}
