// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        System.out.println(solution(nums, target));
    }

    public static int solution(int[] nums, int target) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int low = 0;
        int sum = 0;
        
        for (int high = 0; high < n; high++) {
            sum += nums[high];

            while (sum >= target) {
                int len = high - low + 1;
                minLen = Math.min(minLen, len);
                sum -= nums[low];
                low++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }
}
