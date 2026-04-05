// TC -> O(n)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
    
    public static int findMin(int[] nums) {
        // Logic-
        // Simple linear search

        int n = nums.length;
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] < mini) {
                mini = nums[i];
            }
        }

        return mini;
    }
}
