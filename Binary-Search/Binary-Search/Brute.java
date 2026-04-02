// TC -> O(n)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
    
    public static int search(int[] nums, int target) {
        // Logic is simple-
        // 1. check each element one by one
        // 2. if target is present in arr then its index will be returned
        // 3. otherwise when loop terminates, -1 will be returned
        
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
