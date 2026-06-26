// TC -> O(n)
// SC -> O(1)

public class Optimal {
    private int[] prefixSum;

    public Optimal(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public static void main(String[] agrs) {
        // Logic-
        // Build prefix sum array in one time
        // query sum range afterwards without looping again and again from left to right like in brute solution, in O(1) time query can be responded
        // in this 0-indexed prefixsum used instead of 1-indexed, in 1-indexed n+1 size array would be needed and first element would be 0. we'll not require extra logic i.e. left>0 coz we have extra padding in tht case
        // but this solution looks more easy convenient means 0-indexed

        Optimal nums = new Optimal(new int[] {-2, 0, 3, -5, 2, -1});

        System.out.println(nums.sumRange(0, 5));
        System.out.println(nums.sumRange(0, 2));
        System.out.println(nums.sumRange(2, 5));
    } 
    
    public int sumRange(int left, int right) {
        return left > 0 ? prefixSum[right] - prefixSum[left - 1] : prefixSum[right];
    }    
}
