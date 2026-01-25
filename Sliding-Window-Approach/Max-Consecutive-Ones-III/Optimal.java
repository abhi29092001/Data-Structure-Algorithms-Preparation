// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(solution(nums, k));
    }

    public static int solution(int[] nums, int k) {
        int low = 0;
        int n = nums.length;
        int zeroes = 0;
        int maxLen = 0;

        for (int high = 0; high < n; high++) {
            if (nums[high] == 0) {
                zeroes++;
            }

            while (zeroes > k) {
                if (nums[low] == 0) {
                    zeroes--;
                }
                low++;
            }

            maxLen = Math.max(high - low + 1, maxLen);
        }

        return maxLen;
    }
}
