// TC -> O(n^2)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
