// TC -> O(logn)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(nums, target));
    }
    
    public static int[] searchRange(int[] nums, int target) {
        // Logic-
        // 1. take 2 variables - first and last
        // 2. initialize both of them with -1
        // 3. firstly, we'll find first position by going to the left side
        // 4. similarly, we'll find last position by going to the right side
        // 5. finally, we'll return first and last
        
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int first = -1;
        int last = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{first, last};
    }
}
