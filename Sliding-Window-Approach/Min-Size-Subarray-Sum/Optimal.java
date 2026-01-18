public class Optimal {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        System.out.println(solution(nums, target));
    }

    public static int solution(int[] nums, int target) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;
        int sum = 0;
        
        while (high < n) {
            sum += nums[high];

            while (sum >= target) {
                int len = high - low + 1;
                if (len < minLength) {
                    minLength = len;
                }
                sum -= nums[low];
                low++;
            }

            high++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }

        return minLength;
    }
}
