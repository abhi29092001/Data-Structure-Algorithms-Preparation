// TC -> O(n)
// SC -> O(n)

public class Best {
    public static void main(String[] args) {
        int[] nums = {2, -1, 1};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;

        // Took 2 arrays of size n + 1 to store prefix and suffix sum from 0...i-1 and i+1....n-1
        int[] prefixSum = new int[n + 1];
        int[] suffixSum = new int[n + 1];

        prefixSum[0] = 0;
        suffixSum[n] = 0;

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum[i];
            int rightSum = suffixSum[i + 1];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}
