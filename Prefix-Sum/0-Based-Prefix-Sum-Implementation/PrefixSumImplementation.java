// TC -> O(n)
// SC -> O(n)

// This prefix sum is for 0 to ith element, Other prefix sum is for 0 to (i - 1)th element in that case equation gets changed (prefixSum[i] = prefixSum[i -1] + a[i -1]).
public class PrefixSumImplementation {
    public static void main(String[] args) {
        int[] nums = {10, 20, 10, 5, 15};
        int n = nums.length;
        int[] prefixSum = new int[n];

        // Initializing first element in prefix sum array
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // printing out prefix Sum array
        for (int x : prefixSum) {
            System.out.print(x + " ");
        }
    }
}
