// TC -> O(n)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        // Logic-
        // Simple Linear Search

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
