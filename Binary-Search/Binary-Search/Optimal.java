// TC -> O(logn)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
    
    public static int search(int[] nums, int target) {
        // Logic is simple-
        // 1. take 3 pointers - low, mid -> guess, high
        // 2. if mid is not the target then move accordingly based on whether the mid is less or high then the target
        // 3. if mid is less, move low to mid + 1, ignoring all the elements left to the mid...resulting in reducing search space
        // 4. if mid is high, move high to mid - 1, ignoring all the elements right to the mid...resulting in reducing search space 
        // 5. if target is present then return mid otherwise -1 will be returned when loop terminates

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
